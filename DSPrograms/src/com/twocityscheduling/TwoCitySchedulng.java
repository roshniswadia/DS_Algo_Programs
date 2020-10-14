package com.twocityscheduling;

import java.util.Arrays;
import java.util.Comparator;

/*There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/
public class TwoCitySchedulng {

	public static void main(String[] args) {
		
		int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
		
		 Comparator<int[]> comp = (a,b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
		 Arrays.sort(costs,comp);
	        int minTotal = 0;
	        int acitycount = 0;
	        int bcitycount = 0;
	        int acitytotal = costs.length/2;
	        for(int i=0; i<costs.length; i++){
	            
	            if((costs[i][0] <= costs[i][1] && acitycount <= acitytotal )|| bcitycount == acitytotal ){
	                minTotal = minTotal + costs[i][0];
	                acitycount++;
	            }else{
	                minTotal = minTotal + costs[i][1];
	               bcitycount++;
	            }
	            
	            
	        }
	        
	        System.out.println(minTotal);
	}

}
