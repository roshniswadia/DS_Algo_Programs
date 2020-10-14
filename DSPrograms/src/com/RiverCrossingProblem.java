package com;

import java.util.Arrays;

public class RiverCrossingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RiverCrossingProblem costCal = new RiverCrossingProblem();
		int[] cost = { 30, 40, 60, 70 };
		System.out.println("Max Cost to cross river is : " + costCal.findTotalCost(cost));
	}

	public int findTotalCost(int[] cost) {
		if (cost.length == 0)
			return 0;

		int size = cost.length;
		int max_cost = 0;

		Arrays.sort(cost);

		// decrementing by two as each time we consider two elements in cost calculation
		for (int i = size - 1; i > 1; i = i - 2) {
			if (i == 2) {
				// Case when only 3 elements are left/ or array size is 3
				max_cost += cost[0] + cost[2];
			} else {
				// Case with more than 3 elements
				int cost_one = cost[0] + cost[i] + cost[0] + cost[i - 1];
				int cost_two = cost[i] + cost[0] + cost[1] + cost[1];

				max_cost = max_cost + Math.min(cost_one, cost_two);
			}
		}
		
		if(size ==1) {
			max_cost += cost[0];
		}else {
			//Case where first two elements are remaining to cross the river
			max_cost += cost[1];
		}

		return max_cost;
	}
}
