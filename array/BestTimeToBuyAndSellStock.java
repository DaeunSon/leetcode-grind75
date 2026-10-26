class Solution {
    public int maxProfit(int[] prices) {
        //buy -> sell
        int profit = 0;
        int minPrice = 10000;

        for(int i=0;i<prices.length;i++) {
            if (prices[i] < minPrice) { //최솟값 갱신
                minPrice = prices[i];
            } 

            else if (prices[i] - minPrice > profit) { //최대 수익 계산
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }
}
