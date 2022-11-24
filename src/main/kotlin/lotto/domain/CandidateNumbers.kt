package lotto.domain

import lotto.LottoConstants.LOTTO_NUMBERS_SIZE

object CandidateNumbers {
    private const val ZERO = 0
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45

    private val numbers: List<Int> = (MIN_NUMBER..MAX_NUMBER).toList()

    fun getNumbers() = numbers

    fun pick(): List<Int> {
        return numbers.shuffled().subList(ZERO, LOTTO_NUMBERS_SIZE)
    }

    fun isCandidateNumbers(value: Int) = numbers.contains(value)
}
