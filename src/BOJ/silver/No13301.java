package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long area = 4;
        long prePrev = 1;
        long prev = 1;

        for (int i = 1; i < n; i++) {
            area += prev * 2L;
            long next = prePrev + prev;
            prePrev = prev;
            prev = next;
        }

        System.out.println(area);
    }

}

