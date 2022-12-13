package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
    }

    // TODO: 추가 기능 구현

}
