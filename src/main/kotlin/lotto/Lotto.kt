package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
    }

    // TODO: 추가 기능 구현
    fun makeLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE, LOTTO_COUNT)
    }

    companion object {
        const val RANDOM_START_INCLUSIVE = 1
        const val RANDOM_END_INCLUSIVE = 45
        const val LOTTO_COUNT = 6
    }
}
