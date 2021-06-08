package main;

import java.util.Scanner;

public class JavaSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arrLength = scan.nextInt();
		int[] A = new int[arrLength];
		
		for (int i = 0; i < arrLength; ++i) {
			A[i] = scan.nextInt();
		}
		
		int totalNegSubArrays = 0;
		for (int i = 0; i < arrLength; ++i) {
			int subArrSum = 0;
			for (int j = i; j < arrLength; ++j) {
				subArrSum += A[j];
				totalNegSubArrays += (subArrSum < 0) ? 1 : 0;
			}
		}
		
		System.out.println(totalNegSubArrays);
	}
	
	public static boolean isSumNegative(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum < 0;
	}
	
}
