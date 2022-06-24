package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
	static int line[];
	static int n;
	
	public static boolean check(int l) {
		int c=0;
		for(int i=0;i<line.length;i++) {
			c += line[i]/l;
		}
		
		if (c<n)
			return false;
		else
			return true;
	}
	
	public static int binarySearch(int s,int end) {
		while (end-s>6) {
			int pibot = s+((end-s)/2);
			if (check(pibot))
				s = pibot;
			else
				end = pibot;
			
		}
		return sequentialSearch(s, end);
	}
	
	public static int sequentialSearch(int s,int e) {
		int i;
		for (i =s;i<=e;i++) {
			if (check(i) == false)
				break;
		}
		return i-1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int k= Integer.parseInt(st.nextToken());
		line = new int[k];
		n= Integer.parseInt(st.nextToken());
		int sum = 0;
		boolean maxCheck = false;
		for (int i=0;i<k;i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k;i++) {
			if (sum+line[i]<=sum) {
				maxCheck = true;
				break;
			}
			sum += line[i];
		}
		
		if (maxCheck)
			System.out.print(binarySearch(1, Integer.MAX_VALUE));
		else
			System.out.print(binarySearch(1, sum/n));
		
		br.close();
	}
}