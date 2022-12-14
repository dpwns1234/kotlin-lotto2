package lotto.model

import lotto.Lotto
import lotto.utils.Constants
import lotto.utils.Constants.LOTTO_COUNT
import kotlin.properties.Delegates

class LottoComparator(private val lottos: List<Lotto>) {
    private lateinit var winningLotto: Lotto
    private var bonusNumber by Delegates.notNull<Int>()
    fun setWinningNumberNBonus(winningLotto: Lotto, bonusNumber: Int) {
        this.winningLotto = winningLotto
        this.bonusNumber = bonusNumber
    }

    fun calculateResult(): MutableList<Int> {
        val result = MutableList(LOTTO_COUNT) { 0 }
        for(lotto in lottos) {
            val matchingCount = winningLotto.compare(lotto)
            when(matchingCount) {
                3 -> result[0]++
                4 -> result[1]++
                5 -> if(rightBonus(lotto)) result[2]++
                        else result[3]++
                6 -> result[4]++
            }
        }
        return result
    }
    private fun rightBonus(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }


}