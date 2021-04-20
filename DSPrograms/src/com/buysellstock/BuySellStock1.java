package com.buysellstock;

import java.util.ArrayList;
import java.util.List;

/*the cost of a stock on each day is given in an array, find the max profit that 
you can make by buying and selling in those days. For example, 
if the given array is {100, 180, 260, 310, 40, 535, 695}, 
the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. 
If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.*/
public class BuySellStock1 {

	public static void main(String[] args) {
		int[] arr = {100, 180, 260, 310, 40, 535, 695};
		System.out.println( "Max Profit Equals : " + findMaxProfit(arr));
	}
	
	static class BuySellInterval{
		int buyIndex;
		int sellIndex;
		 public void setBuyIndex(int buyIndex) {
			this.buyIndex = buyIndex;
		}
		 
		 public void setSellIndex(int sellIndex) {
			this.sellIndex = sellIndex;
		}
		 
		 public int getSellIndex() {
			return sellIndex;
		}
		 
		 public int getBuyIndex() {
			return buyIndex;
		}
	}
	public static int findMaxProfit(int[] inputArr) { 
		int i = 0;
		int lengthOfArray = inputArr.length;
		int totalProfit = 0;
		while(i < lengthOfArray - 1) {
			while(i < lengthOfArray -1 && inputArr[i + 1] < inputArr[i] ) {
				i++;
			}
			int buyingPrice = inputArr[i];
			
			while(i < lengthOfArray -1 && inputArr[i + 1] > inputArr[i]) {
				i++;
			}
			int sellingPrice = inputArr[i];
			totalProfit = totalProfit + (sellingPrice - buyingPrice);
		}
		return totalProfit;
	}
	
}
