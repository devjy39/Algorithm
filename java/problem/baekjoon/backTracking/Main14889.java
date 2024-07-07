package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
	public static int halfN;
	public static int[][] s;
	public static int[] visit;
	public static int min=Integer.MAX_VALUE;
	
	public static void dfs(int depth,int preNum) {
		if(depth==halfN) {
			int diff = calculatePoints(); 
			min = min<diff ? min:diff;
			return;
		}
		
		for(int i=preNum;i<visit.length;i++) {
			visit[i]=1;
			dfs(depth+1,i+1);
			visit[i]=0;
		}
	}
	
	public static int calculatePoints() {
		int t1=0;
		int t2=0;
		
		for (int i = 0; i < s.length; i++) {
			for (int j = i+1; j < s[i].length; j++) {
				if (visit[i] == visit[j]) {
					if (visit[i] == 0) 
						t1+=s[i][j];
					else
						t2+=s[i][j];
				}
			}
		}
		return t1>t2 ? t1-t2:t2-t1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visit = new int[n];
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				if(i<j)
					s[i][j] =Integer.parseInt(st.nextToken());
				else
					s[j][i] += Integer.parseInt(st.nextToken());
			}
		}
		halfN = n/2;
		
		dfs(0,0);
		System.out.println(min);
		br.close();
	}
}