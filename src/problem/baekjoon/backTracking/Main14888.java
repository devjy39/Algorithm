package problem.baekjoon.backTracking;

import java.util.Scanner;

public class Main14888 {
	public static int[] arr;
	public static int[] oper;
	public static int max, min;
	
	public static void dfs(int depth, int num) {
		if(depth==arr.length) {
			max = max<num ? num:max;
			min = min>num ? num:min;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(oper[i]!=0) {
				oper[i]--;
				dfs(depth+1,calculator(num,arr[depth],i));
				oper[i]++;
			}
		}
	}
	
	public static int calculator(int num,int num2, int o) {
		switch (o) {
		case 0:
			return num+num2;
		case 1:
			return num-num2;
		case 2:
			return num*num2;
		case 3:
			return (int)(num/num2);
		default:
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		oper = new int[4];
		for(int i=0;i<4;i++)
			oper[i] = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(1,arr[0]);
		System.out.print(max+"\n"+min);
		sc.close();
	}
}