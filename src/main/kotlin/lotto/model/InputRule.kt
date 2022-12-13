package lotto.model

class InputRule {
    
    fun checkPurchaseAccount(input: String): Int {
        //     - [ ] ERROR 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
        val account = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자 입력해주세요.")
        if(account % 1000 != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요")
        return account
    }

    fun checkWinningLotto(input: String): Int {

    }
}