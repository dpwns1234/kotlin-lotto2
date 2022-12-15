package lotto.view

import lotto.Lotto
import lotto.model.LottoComparator
import lotto.model.LottoMachine

class OutputView {

    fun printRequireAmount() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseResult(lottoMachine: LottoMachine) {
        printPurchaseCount(lottoMachine.getPurchaseCount())
        printSortedLotts(lottoMachine.getLottos())
    }
    private fun printPurchaseCount(count: Int) {
        println(MESSAGE_PURCHASE_COUNT.format(count))
    }
    private fun printSortedLotts(lottos: List<Lotto>) {
        for(lotto in lottos) {
            val str = StringBuilder()
            str.append("[")
            str.append(lotto.formattingNumbers())
            str.append("]")
            println(str)
        }
    }
    fun printRequireWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
    }
    fun printRequireBonus() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printResult(lottoComparator: LottoComparator) {
        printResultStatistics(lottoComparator.matchingResult)
        printProfitRatio(lottoComparator.profit)
    }

    private fun printResultStatistics(result: List<Int>) {
        println("당첨 통계")
        for ((index, rank) in Rank.values().reversed().withIndex()) {
            println(rank.message.format(result[index]))
        }
    }

    private fun printProfitRatio(profit: Double) {
        println(MESSAGE_PROFIT_RATIO.format(profit))
    }



    enum class Rank(val message: String, val profit: Int) {
        FIRST_GRADE("6개 일치 (2,000,000,000원) - %d개", 2000000000),
        SECOND_GRADE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
        THIRD_GRADE("5개 일치 (1,500,000원) - %d개", 1500000),
        FOURTH_GRADE("4개 일치 (50,000원) - %d개", 50000),
        FIFTH_GRADE("3개 일치 (5,000원) - %d개", 5000)
    }


    companion object {
        const val MESSAGE_PURCHASE_COUNT = "%d개를 구매했습니다."
        const val MESSAGE_PROFIT_RATIO = "총 수익률은 %.1f%%입니다."
    }
}