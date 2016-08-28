/**
 * Problem
 * - Given a sequence of stock denoting daily stock prices, return the maximum profit
 * - that can be made by buying and then selling two shares of the stock.
 * - The second trade's buy must happen after the first trade's sell.
 *
 * Example
 * - Input: [12, 11, 13, 9, 12, 8, 14, 13, 15]
 * - Output: 10 (buy on fourth day, sell on fifth day, buy on sixth day, sell on nineth day)
 *
 */
public class Advanced {

    public static int maximumProfitSellTwice(int[] prices) {

        int[] forward = new int[prices.length];

        // consider buying first and then selling
        // iterate forward, keeping track of two variables
        // 1) minimum price seen so far
        // 2) max profit = Math.max(currentPrice - minimumSeenSoFar, maxProfit)
        // record max profit
        int minPriceSoFar = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
            forward[i] = maxProfit;
        }

        // consider selling first then buying
        int[] backward = new int[prices.length];
        int maxPriceSoFar = prices[prices.length - 1];
        maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices[i]);
            backward[i] = maxProfit;
        }

        int maxProfitSellTwice = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxProfitSellTwice = Integer.max(maxProfitSellTwice, forward[i] + backward[i]);
        }

        return maxProfitSellTwice;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{12, 11, 13, 9, 12, 8, 14, 13, 15};
        System.out.print(maximumProfitSellTwice(prices));
    }
}
