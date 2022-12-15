package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
    }

    // TODO: 추가 기능 구현
    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun compare(lotto: Lotto): Int {
        var count = 0
        for(number in numbers) {
            if(lotto.contains(number))
                count++
        }
        return count
    }

    fun formattingNumbers(): String {
        var formatting = ""
        for (number in numbers) {
            formatting = formatting.plus(number).plus(", ")
        }

        return formatting.substring(0, formatting.length - 2)
    }

}
