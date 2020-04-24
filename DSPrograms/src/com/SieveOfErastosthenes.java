package com;

public class SieveOfErastosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 53;

		boolean[] isPrime = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			isPrime[i] = true;
		}

		isPrime[0] = true;
		isPrime[1] = true;

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int j = 2; i * j <= n; j++) {
					isPrime[i*j] = false;
				}
			}
		}

		// Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(isPrime[i] == true) 
                System.out.print(i + " "); 
        } 
	}

}
