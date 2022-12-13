package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Lotto
import lotto.model.InputRule

class InputView {
    private val inputRule = InputRule()
    fun purchaseAccount(): Int {
        val input = readLine()
        var account = 0
        kotlin.runCatching { account = inputRule.checkPurchaseAccount(input) }
            .onFailure { e ->
                println(e.message)
                return -1
            }
        return account
    }

    fun winningLotto(): Lotto {
        while (true) {
            val input = readLine()
            var lottoNumber = listOf<Int>()
            kotlin.runCatching { lottoNumber = inputRule.checkWinningLotto(input) }
                .onSuccess { return Lotto(lottoNumber) }
                .onFailure { e -> println(e.message) }
        }
    }

    fun bonusNumber(winningLotto: Lotto): Int {
        while(true) {
            val input = readLine()
            kotlin.runCatching { inputRule.checkBonusNumber(input, winningLotto) }
                .onSuccess { return input.toInt() }
                .onFailure { e -> println(e.message) }
        }
    }
}