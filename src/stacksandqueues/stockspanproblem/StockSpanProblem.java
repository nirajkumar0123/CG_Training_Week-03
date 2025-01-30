package stacksandqueues.stockspanproblem;

import java.util.Stack;

class StockSpanProblem {

    public void calculateStockSpan(int[] stockPrice) {
        Stack<Integer> stack = new Stack<>();

        int n = stockPrice.length;
        int[] pricetracker = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stockPrice[stack.peek()] <= stockPrice[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                pricetracker[i] = i + 1;
            } else {
                pricetracker[i] = i - stack.peek();
            }

            stack.push(i);
        }

        for (int i : pricetracker) {
            System.out.print(i + " ");
        }

    }
}
