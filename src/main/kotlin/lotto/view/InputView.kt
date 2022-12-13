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

    fun winningLotto(): Lotto? {
        while (true) {
            val input = readLine()
            var winningLotto: Lotto? = null
            kotlin.runCatching { winningLotto = inputRule.checkWinningLotto(input) }
                .onSuccess { return winningLotto }
                .onFailure { e -> println(e.message) }
        }
    }
}