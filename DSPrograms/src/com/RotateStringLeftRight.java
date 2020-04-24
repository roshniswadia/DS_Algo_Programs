package com;import com.DiameterOfBinaryTree.A;

public class RotateStringLeftRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateStringLeftRight rotate = new RotateStringLeftRight();
		String str = "qwertyu";
		String newString;
		int[][] arr = {{0,1},{1,4},{0,3}};
		
		for(int i=0,j=0; i<arr.length; i++) {
			if(arr[i][j] == 0) {
				str = rotate.leftRotation(str, arr[i][j+1]);
				System.out.println("Left Rotation : " + str);
			}else {
				str = rotate.rightRotation(str, arr[i][j+1]);
				System.out.println("Right Rotation : " + str);
			}
		}
	}
	
	public String leftRotation(String a, int num) {
		return a.substring(num) + a.substring(0, num);
	}
	
	public String rightRotation(String b, int num) {
		return leftRotation(b, b.length() - num);
	}

}
