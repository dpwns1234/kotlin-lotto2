package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_COUNT

class LottoMachine {
    fun makeLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            RANDOM_START_INCLUSIVE,
            RANDOM_END_INCLUSIVE,
            LOTTO_COUNT
        )

        return Lotto(numbers)
    }


    companion object {
        const val RANDOM_START_INCLUSIVE = 1
        const val RANDOM_END_INCLUSIVE = 45
    }
}