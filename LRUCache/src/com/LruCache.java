package com;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LruCache {
	
	public Deque<Integer> dequeue;
	public Set<Integer> cacheSet;
	int max_capacity;
	
	public LruCache(Deque<Integer> dequeue, Set<Integer> set , int max_capacity) {
		this.dequeue = dequeue;
		this.cacheSet = set;
		this.max_capacity = max_capacity;
	}
	
	public int getElement(int n) {
		
		if(!cacheSet.contains(n)) {
			System.out.println("Queue Before removing last element : ");
			dequeue.forEach(a -> System.out.println(a));
			if(dequeue.size() == max_capacity) {
				cacheSet.remove(dequeue.removeLast());
				System.out.println("Queue After removing last element : ");
				dequeue.forEach(a -> System.out.println(a));
			}
		}else {
			dequeue.remove(n);
			System.out.println("Queue After removing element : ");
			dequeue.forEach(a -> System.out.println(a));
		}
		
		dequeue.push(n);
		cacheSet.add(n);
		System.out.println("Queue After inserting element : ");
		dequeue.forEach(a -> System.out.println(a));
		return n;
	}
	
	public static void main(String[] args) {
		Deque<Integer> dequeue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		int max_capacity = 10;
		
		for(int i=1; i<=10; i++) {
			dequeue.add(i);
			set.add(i);
		}
		LruCache cache = new LruCache(dequeue, set, max_capacity);
		
		cache.getElement(12);
	}
	
}
