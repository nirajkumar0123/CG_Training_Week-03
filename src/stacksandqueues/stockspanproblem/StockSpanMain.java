package stacksandqueues.stockspanproblem;

public class StockSpanMain {
    public static void main(String[] args) {
         int[] prices = {100, 80, 60, 70, 60, 75, 85};
         StockSpanProblem prob = new StockSpanProblem();
         prob.calculateStockSpan(prices);
    }
}
