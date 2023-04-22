import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      String[] e = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
      int d = 1;
      int month = 1;
      int ed = 0;
      int dayN = 0;

      while (x != month || y != d) {
         if (d + 1 > day[dayN]) {
            d = 0;
            month++;
            dayN++;
         }
         ed = (ed + 1) % 7;
         d++;
      }
      System.out.println(e[ed]);
   }

}
