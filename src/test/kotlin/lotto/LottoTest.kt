package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.model.InputRule
import lotto.view.InputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LottoTest : NsTest() {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능

    // 이 부분만 예외시 종료로 만들어보고, 나머지는 다시 입력받도록 에러메세지만 받도록 작성해보기
    @Test
    fun `1000원 단위가 아닐경우 예외 발생`() {
        assertSimpleTest {
            runException("1000j")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    // TODO 왜 그냥 run("1000", "123")으로 하면 ERROR를 찾을 수 없다고 할까? 무슨 차이일까?
    @Test
    fun `입력된 당첨번호가 6자리가 아닐 경우 에러 메세지 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    //    @ValueSource(strings = ["1000", "123456"])
//    @ParameterizedTest
    @Test
    fun `입력된 당첨번호 또는 보너스 번호가 중복될 경우 에러메시지 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,5")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `입력된 당첨번호가 ','로 구분되어지지 않은 경우 에러메세지 발생`() {
        assertSimpleTest {
            runException("1000", "123456")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }

    @Test
    fun `보너스 번호가 당첨번호와 중복됐을 경우`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                runException("8000", "1,2,3,4,5,6", "6")
                Assertions.assertThat(output()).contains("[ERROR]")

            }, listOf(1, 2, 3, 4, 5, 6)
        )
    }

    override fun runMain() {
        main()
    }

}
