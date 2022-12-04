package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.PurchaseAmount
import lotto.domain.UserLottos
import lotto.domain.WinningLottoNumbers

object InputView {
    private const val INVALID_INPUT_ERROR_MESSAGE = "로또 번호는 숫자만 입력할 수 있습니다."
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요.")
        return PurchaseAmount(readln().toInt())
    }

    fun getManualNumberOfLotto(purchaseAmount: PurchaseAmount): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val numberOfLottoByManual = readln().toInt()
        if (!purchaseAmount.canBuyNumberOfLotto(numberOfLottoByManual)) {
            throw IllegalArgumentException("구매할 수 없는 개수입니다.")
        }
        if (numberOfLottoByManual < 0) {
            throw IllegalArgumentException("올바른 수를 입력해 주세요.")
        }

        return numberOfLottoByManual
    }

    fun getManualLottos(numberOfLottoByManual: Int): UserLottos {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        var userLottos = UserLottos()
        repeat(numberOfLottoByManual) {
            val inputLottoNumbers = readln()
            userLottos = userLottos.add(validateLottoNumbers(inputLottoNumbers))
        }
        return userLottos
    }

    fun getWinningLottoNumbers(): WinningLottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputLottoNumbers = readln()
        val lottoNumbers = validateLottoNumbers(inputLottoNumbers)

        println("보너스 볼을 입력해 주세요.")
        val inputBonusBall = LottoNumber(readln().toInt())

        return WinningLottoNumbers(lottoNumbers = lottoNumbers, bonusLottoNumber = inputBonusBall)
    }

    private fun validateLottoNumbers(input: String): LottoNumbers {
        val strings = input.replace(" ", "").split(",")
        val lottoNumbers = strings.map { convertStringToLottoNumber(it) }
        return LottoNumbers(lottoNumbers.toSet())
    }

    private fun convertStringToLottoNumber(value: String): LottoNumber {
        val number = value.toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        return LottoNumber(number)
    }
}
