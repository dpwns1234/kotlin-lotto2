package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Constants.LOTTO_COUNT

class LottoMachine(private val purchaseAmount: Int) {
    private val purchaseLottos = mutableListOf<Lotto>()

    fun getPurchaseCount(): Int {
        return purchaseAmount / 1000
    }

    fun purchaseLottos() {
        for (i in 0 until getPurchaseCount()) {
            makeLotto()
        }
    }

    private fun makeLotto() {
        val numbers = Randoms.pickUniqueNumbersInRange(
            RANDOM_START_INCLUSIVE,
            RANDOM_END_INCLUSIVE,
            LOTTO_COUNT
        )
        purchaseLottos.add(Lotto(numbers.sorted()))
    }

    fun getLottos(): List<Lotto> {
        return purchaseLottos
    }

    companion object {
        const val RANDOM_START_INCLUSIVE = 1
        const val RANDOM_END_INCLUSIVE = 45
    }
}