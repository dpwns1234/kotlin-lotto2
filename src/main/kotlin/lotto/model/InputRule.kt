package lotto.model

import lotto.Lotto
import lotto.utils.Constants.LOTTO_COUNT

class InputRule {

    fun checkPurchaseAccount(input: String): Int {
        val account = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자 입력해주세요.")
        if (account % 1000 != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요")
        return account
    }

    fun checkWinningLotto(input: String): Lotto {
        val numbers = input.split(",")
        if (numbers.size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 형식에 맞게 6자리를 입력해주세요.")
        if (numbers.distinct().size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 중복된 숫자는 입력하지마세요.")

        return checkLottoNumberOfRange(numbers)
    }

    private fun checkLottoNumberOfRange(numbers: List<String>): Lotto {
        val winningNumbers = mutableListOf<Int>()
        for (number in numbers) {
            if (number.toInt() in (1..45))
                winningNumbers.add(number.toInt())
        }
        if (winningNumbers.size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 범위에서 벗어났거나 문자를 입력하셨습니다.")
        return Lotto(winningNumbers)
    }

    fun checkBonusNumber(input: String) {
        // - [ ] ERROR 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다. (6자리와 보너스도 중복 x)
    }
}