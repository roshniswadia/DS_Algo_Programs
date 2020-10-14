package com;

import java.util.ArrayList;
import java.util.List;

public class MinStepsInfiniteGrid {

	public static void main(String[] args) {
		MinStepsInfiniteGrid steps = new MinStepsInfiniteGrid();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list1.add(2);
		
		list2.add(0);
		list2.add(1);
		list2.add(2);
		
		System.out.println("Min Stpes : " + steps.coverPoints(list1, list2));
	}

public int coverPoints(List<Integer> list1, List<Integer> list2) {
        
        int min_steps = 0;
        
        if(list1.size() != list2.size() || list1.size() <=1 || list2.size() <= 1)
            return 0;
            
        for(int i =0; i < list1.size() -1; i++){
            
            min_steps = min_steps + shortestPath(list1.get(i), list1.get(i+1), list2.get(i), list2.get(i +1));
        }
        
        return min_steps;
    }
    
    static int shortestPath(int x1, int x2, int y1, int y2){
        int dx1 = Math.abs(x1-x2);
        int dx2 = Math.abs(y1-y2);
        
        return Math.max(dx1,dx2);
    }
}
