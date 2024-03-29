package problem.baekjoon.sort;

import java.io.*;
import java.util.*;

public class No1181 {

     public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = br.readLine();
        }
        
        Arrays.sort(str,(s1,s2)->s1.length()==s2.length()?s1.compareTo(s2):s1.length()-s2.length());
        
        StringBuilder result = new StringBuilder();
        result.append(str[0]).append("\n");

        for(int i = 1; i < n; i++) {
            if (!str[i].equals(str[i - 1])) {
                result.append(str[i]).append("\n");
            }
        }
        
        System.out.print(result);
     }
}

