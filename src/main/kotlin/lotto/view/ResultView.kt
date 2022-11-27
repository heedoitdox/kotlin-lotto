package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

object ResultView {
    fun printNumberOfPurchases(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printRewardsStatistics(winningStatistics: WinningStatistics) {
        println("\n당첨 통계")
        println("---------")
        Rank.values().forEach {
            println("${it.numberOfMatch}개 일치 (${it.winningMoney}원)- ${winningStatistics.getNumberOfMatchCount(it)}개")
        }
    }

    fun printRateOfReturn(rateOfReturn: BigDecimal) {
        print("총 수익률은 $rateOfReturn 입니다.")
        if (rateOfReturn < BigDecimal(1)) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun printPurchasedLotto(myLotteries: List<LottoNumbers>) {
        myLotteries.forEach { lotto ->
            val sortedValue = lotto.lottoNumbers.sortedWith(compareBy { it.toString() })
            println("[${sortedValue.joinToString(", ")}]")
        }
    }
}
