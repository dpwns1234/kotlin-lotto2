package lotto

import lotto.model.LottoComparator
import lotto.view.InputView
import lotto.view.OutputView
import kotlin.math.round

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun runGame() {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = inputView.purchaseAccount()
        if(purchaseAmount == -1)
            return
        val purchaseCount = purchaseAmount / 1000

        // 로또 생성 TODO (어디에 저장할 것인가?)
        val lottos = mutableListOf<Lotto>()
        for(i in 0 until purchaseCount) {
            val lotto = LottoMachine().makeLotto()
            lottos.add(lotto)
        }

        // TODO 이것도 어디에 저장할 것인가?
        println("당첨 번호를 입력해 주세요.")
        val winningLotto = inputView.winningLotto()

        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = inputView.bonusNumber(winningLotto)

        // 당첨 결과 계산
        val lottoComparator = LottoComparator(lottos)
        lottoComparator.setWinningNumberNBonus(winningLotto, bonusNumber)

        val result = lottoComparator.calculateResult()
        println("당첨 통계")
        outputView.printResult(result)

        calculateProfit(result, purchaseAmount)
    }

    // 수익률 공식: 100 + (당첨금 - 구매 금액) / 구매 금액 * 100
    private fun calculateProfit(result: List<Int>, purchaseAmount: Int) {
        var prizeAmount: Long = 0
        for((index, rank) in OutputView.Rank.values().reversed().withIndex()) {
            prizeAmount += rank.profit * result[index]
        }

        var profit = 100 + (prizeAmount - purchaseAmount) / purchaseAmount.toDouble() * 100
        profit = round(profit * 10) / 10

        outputView.printProfitRatio(profit)
    }
}