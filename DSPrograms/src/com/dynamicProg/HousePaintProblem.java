package com.dynamicProg;

/*There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.*/
public class HousePaintProblem {

	public static void main(String[] args) {
		int[][] costMatrix = {{14,2,11},{11,14,5},{14,3,10}};
		int cost = findMinCost(costMatrix);
		System.out.println("Min Cost : " + cost);
	}
	
	public static int findMinCost(int[][] cost) {
		int noOfHouse = cost.length;
		
		for(int i=1; i<noOfHouse; i++) {
			cost[i][0] = cost[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] = cost[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] = cost[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		
		return Math.min(Math.min(cost[noOfHouse - 1][0], cost[noOfHouse -1][1]), cost[noOfHouse - 1][2]);
	}
}
