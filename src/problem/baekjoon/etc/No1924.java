package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1924 {
   static final String[] DAY_OF_WEEK = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
   static final int[] DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int dayCount = 0;
      for (int i = 0; i < x - 1; i++) {
         dayCount += DAY[i];
      }
      dayCount += y - 1;

      System.out.println(DAY_OF_WEEK[dayCount % 7]);
   }

}
