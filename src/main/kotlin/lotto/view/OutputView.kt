package lotto.view

import lotto.model.MatchingResult
import lotto.utils.Constants.LOTTO_COUNT

class OutputView {
    fun printResult(result: List<Int>) {
        for((index, rank) in Rank.values().reversed().withIndex()) {
            println(rank.message.format(result[index]))
        }
    }

    fun printProfitRatio(profit: Double) {
        println(MESSAGE_PROFIT_RATIO.format(profit))
    }

    enum class Rank(val message: String, val profit: Int) {
        FIRST_GRADE("6개 일치 (2,000,000,000원) - %d개", 2000000000),
        SECOND_GRADE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
        THIRD_GRADE("5개 일치 (1,500,000원) - %d개", 1500000),
        FOURTH_GRADE("4개 일치 (50,000원)) - %d개", 50000),
        FIFTH_GRADE("3개 일치 (5,000원) - %d개", 5000)
    }


    companion object {
        const val MESSAGE_PROFIT_RATIO = "총 수익률은 %.1f%%입니다."
    }
}