import java.util.*;
import java.io.*;

public class No1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        
        int[] counts = new int[10];
        for(int i=0; i<numbers.length();i++) {
            int number = numbers.charAt(i)-'0';
            counts[number]++;
        }

        int sum69 = counts[6]+counts[9];
        counts[6] = sum69 >> 1;
        counts[9] = sum69 - counts[6];
      
      
        int maxSetCount = 0;
        for (int count : counts) {
            maxSetCount = Math.max(maxSetCount, count);
        }

        System.out.println(maxSetCount);
    }
}
