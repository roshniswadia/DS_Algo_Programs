package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/*Given an array arr of strings, the task is to remove the strings 
that are an anagram of an earlier string,
\then print the remaining array in sorted order.*/

public class RemoveAnagramsFromListofStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"code", "aaagmnrs", "anagrams", "doce"};
		List<String> ans = removeAnagrams(arr, 4);
		// Print the required array
	    for (int i = 0; i < ans.size(); ++i) {
	        System.out.print(ans.get(i)+ " ");
	    }
	}

	static List<String> removeAnagrams(String arr[], int N)
	{// vector to store the final result
	    Vector<String> ans = new Vector<String>();
	    
	    // data structure to keep a mark
	    // of the previously occured String
	    HashSet<String> found = new HashSet<String> ();
	  
	    for (int i = 0; i < N; i++) {
	  
	        String word = arr[i];
	  
	        // Sort the characters
	        // of the current String
	        word = sort(word);
	  
	        // Check if current String is not
	        // present inside the hashmap
	        // Then push it in the resultant vector
	        // and insert it in the hashmap
	        if (!found.contains(word)) {
	  
	            ans.add(arr[i]);
	            found.add(word);
	        }
	    }
	  
	    // Sort the resultant vector of Strings
	    Collections.sort(ans);
	  return ans;
	}
	static String sort(String inputString)
	{
	    // convert input string to char array
	    char tempArray[] = inputString.toCharArray();
	       
	    // sort tempArray
	    Arrays.sort(tempArray);
	       
	    // return new sorted string
	    return new String(tempArray);
	}
	
	
	
}
