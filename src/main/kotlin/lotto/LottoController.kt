package lotto

import lotto.model.LottoComparator
import lotto.model.LottoMachine
import lotto.utils.Constants.INPUT_ERROR
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var lottoMachine: LottoMachine
    private lateinit var lottoComparator: LottoComparator
    fun runGame() {
        val purchaseAmount = purchaseAmount() ?: return
        purchaseLottos(purchaseAmount)

        val (winningLotto, bonusNumber) = inputWinningNumberNbonus()
        result(winningLotto, bonusNumber, purchaseAmount)
    }

    private fun purchaseAmount(): Int? {
        outputView.printRequireAmount()
        return inputView.purchaseAccount()
    }

    private fun purchaseLottos(purchaseAmount: Int) {
        lottoMachine = LottoMachine(purchaseAmount)
        lottoMachine.purchaseLottos()
        outputView.printPurchaseResult(lottoMachine)
    }

    private fun inputWinningNumberNbonus(): Pair<Lotto, Int> {
        outputView.printRequireWinningNumber()
        val winningLotto = inputView.winningLotto()

        outputView.printRequireBonus()
        val bonusNumber = inputView.bonusNumber(winningLotto)
        return Pair(winningLotto, bonusNumber)
    }
    private fun result(winningLotto: Lotto, bonusNumber: Int, purchaseAmount: Int) {
        lottoComparator = LottoComparator(lottoMachine.getLottos(), winningLotto, bonusNumber)
        lottoComparator.calculateResult(purchaseAmount, bonusNumber)
        outputView.printResult(lottoComparator)
    }
}