package com;

import java.util.ArrayList;
import java.util.List;

/*An array is given as Input where ith element is the price of a given stock on day 
You were permitted to complete unlimited transaction. 
Derive an algorithm to find the maximum profit in O(n) Time complexity and O(n) Space*/
public class MaximumStockProfit {

	public static void main(String[] args) {
		int[] arr = { 98, 178, 250, 300, 40, 540, 690 };
		List<Result> profitIndexList = new ArrayList<>();
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < arr.length;) {
			MaximumStockProfit.Result index = new MaximumStockProfit.Result();
			while (i < n - 1 && arr[i + 1] < arr[i])
				i++;

			if (i == n - 1)
				break;

			index.buy = i++;

			while (i < n && arr[i - 1] < arr[i]) {
				i++;
			}

			index.sell = i - 1;
			count++;
			profitIndexList.add(index);

		}

		int totalProfit = 0;
		for (int i = 0; i < count; i++) {
			totalProfit = totalProfit + (arr[profitIndexList.get(i).sell] - arr[profitIndexList.get(i).buy]);
		}
		System.out.println(totalProfit);

	}

	static class Result {
		int buy;
		int sell;
	}

}
