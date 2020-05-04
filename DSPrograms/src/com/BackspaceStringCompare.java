package com;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "ab#c";
		String s2 = "ad#c";
		
		String s3 = "xywrrmp";
		String s4 = "xywrrmu#p";
		
		String s5 = "bbbextm";
		String s6 = "bbb#extm";
		
		//System.out.println("The two string are equal : " + compareString(s1, s2));
		
		System.out.println("The two strings are equal : " + compareString(s5, s6));

	}
	
	public static boolean compareString(String S, String T) {
		
		int s_pointer = S.length() - 1;
		int t_pointer = T.length() - 1;
		
		int s_skips = 0;
		int t_skips = 0;
		
		while(s_pointer >=0 || t_pointer >= 0) {
			while(s_pointer >= 0) {
				if(S.charAt(s_pointer) == '#') {
					s_pointer--;
					s_skips++;
				}else if(s_skips >0) {
					s_skips--;
					s_pointer--;
				}else {
					break;
				}
			}
			
			while(t_pointer >= 0) {
				if(T.charAt(t_pointer) == '#') {
					t_pointer--;
					t_skips++;
				}else if(t_skips > 0) {
					t_skips--;
					t_pointer--;
				}else {
					break;
				}
			}
			
			if(s_pointer >=0 && t_pointer >= 0 && S.charAt(s_pointer) != T.charAt(t_pointer))
				return false;
			
			if((s_pointer >=0) != (t_pointer >=0))
				return false;
			
			s_pointer--;
			t_pointer--;
		}
		
		return true;
	}

}
