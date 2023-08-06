package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10973 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getPermutation(arr, n));
    }

    private static String getPermutation(int[] arr, int n) {
        int targetIdx = -1;
        for (int i = n - 1; i > 0; i--) { // 내림차순 잡아내기
            if (arr[i - 1] > arr[i]) {
                targetIdx = i - 1;
                break;
            }
        }

        if (targetIdx == -1) {
            return String.valueOf(targetIdx);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < targetIdx; i++) {
            visited[arr[i]] = true;
        }

        for (int i = arr[targetIdx] - 1; i >= 1; i--) { // 방문하지 않고 타켓보단 작은데 젤 큰애
            if (!visited[i]) {
                arr[targetIdx] = i;
                visited[arr[targetIdx]] = true;
                break;
            }
        }

        int top = n + 1;
        for (int i = targetIdx + 1; i < n; i++) {
            while (visited[--top]);
            arr[i] = top;
            visited[top] = true;
        }

        StringBuilder result = new StringBuilder(arr.length);
        for (int i : arr) {
            result.append(i).append(" ");
        }
        return result.toString();
    }

}

