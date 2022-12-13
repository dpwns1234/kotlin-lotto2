package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoComparator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun runGame() {
        println("구입금액을 입력해 주세요.")
        val input = inputView.purchaseAccount()
        if(input == -1)
            return
        // 로또 생성 TODO (어디에 저장할 것인가?)
        for(i in 0 until input/1000) {
            // Lotto().makeLotto()
        }

        println("당첨 번호를 입력해 주세요.")
        val winningLotto = Console.readLine()
        // 입력값 체크

        // convert string to list

        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()
        // 중복 체크 등 입력값 체크

        // 당첨 결과 계산
        LottoComparator()
        println("당첨 통계")
    }
}