package lotto.model

import lotto.Lotto
import lotto.utils.Constants.LOTTO_COUNT

class InputRule {

    fun checkPurchaseAccount(input: String): Int {
        val account = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자 입력해주세요.")
        if (account % 1000 != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요")
        return account
    }

    fun checkWinningLotto(input: String): List<Int> {
        val numbers = input.split(",")
        if (numbers.size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 형식에 맞게 6자리를 입력해주세요.")
        if (numbers.distinct().size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 중복된 숫자는 입력하지마세요.")

        return checkLottoNumberOfRange(numbers)
    }

    private fun checkLottoNumberOfRange(numbers: List<String>): List<Int> {
        val winningNumbers = mutableListOf<Int>()
        for (number in numbers) {
            if (number.toInt() in (1..45))
                winningNumbers.add(number.toInt())
        }
        if (winningNumbers.size != LOTTO_COUNT) throw IllegalArgumentException("[ERROR] 범위에서 벗어났거나 문자를 입력하셨습니다.")
        return winningNumbers
    }

    fun checkBonusNumber(input: String, winningLotto: Lotto) {
        val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자 입력해주세요.")
        if((bonusNumber in 1..45).not()) throw IllegalArgumentException("[ERROR] 1-45범위 안에 숫자를 입력해주세요.")
        if(winningLotto.contains(bonusNumber)) throw IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않은 보너스 번호를 입력해주세요.")
    }
}