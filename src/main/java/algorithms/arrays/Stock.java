package algorithms.arrays;

public class Stock {

    public int maxProfitBrute(int[] prices) {
        //Gives time limit exceeded on very large inputs
        int sellPriceSoFar = Integer.MIN_VALUE;
        int buyIndex = 0, sellIndex = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int k = i + 1; k < prices.length; k++) {
                if ((prices[k] - prices[i]) > sellPriceSoFar) {
                    sellPriceSoFar = Math.max(sellPriceSoFar, (prices[k] - prices[i]));
                    buyIndex = i;
                    sellIndex = k;

                }
            }
        }

        System.out.println("Best time to buy: " + buyIndex + " best time to sell: " + sellIndex);
        return Math.max(sellPriceSoFar, 0);
    }

    public int maxProfit(int[] prices) {
        // Asuuming awareness about basic stock market ops, the point here really is that if the difference between ith day
        // and some day in the future is positive , we want to ensure that its greater than whatever we have got so far.
        // Else if negative, it means that we have stumbled upon something cheaper than the rate at which we are trying to buy
        // right now .Therefore, buy at this rate and then try maximising the profit than that seen so far.

        int L = 0, maxProfitSoFar = 0;
        for (int R = 1; R < prices.length; R++) {
            if ((prices[R] - prices[L]) > 0) {
                maxProfitSoFar = Math.max(maxProfitSoFar, (prices[R] - prices[L]));
            } else {
                L = R;
            }
        }
        return maxProfitSoFar;
    }
}
