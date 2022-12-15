package lotto.model

import lotto.Lotto
import lotto.utils.Constants
import lotto.utils.Constants.LOTTO_COUNT
import lotto.view.OutputView
import kotlin.math.round
import kotlin.properties.Delegates

class LottoComparator(private val lottos: List<Lotto>, private val winningLotto: Lotto, bonusNumber: Int) {
    var matchingResult = mutableListOf<Int>()
    var profit by Delegates.notNull<Double>()

    fun calculateResult(purchaseAmount: Int, bonusNumber: Int) {
        val result = MutableList(LOTTO_COUNT) { 0 }
        for(lotto in lottos) {
            val matchingCount = winningLotto.compare(lotto)
            when(matchingCount) {
                3 -> result[0]++
                4 -> result[1]++
                5 -> if(rightBonus(lotto, bonusNumber)) result[2]++
                        else result[3]++
                6 -> result[4]++
            }
        }
        matchingResult = result
        calculateProfit(purchaseAmount)
    }
    private fun rightBonus(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.contains(bonusNumber)
    }

    // 수익률 공식: 100 + (당첨금 - 구매 금액) / 구매 금액 * 100
    private fun calculateProfit(purchaseAmount: Int) {
        var prizeAmount: Long = 0
        for((index, rank) in OutputView.Rank.values().reversed().withIndex()) {
            prizeAmount += rank.profit * matchingResult[index]
        }

        var profit = 100 + (prizeAmount - purchaseAmount) / purchaseAmount.toDouble() * 100
        profit = round(profit * 10) / 10
        this.profit = profit
    }

}