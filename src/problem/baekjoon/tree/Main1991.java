package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1991 {
    static StringBuilder result;
    static HashMap<String, String[]> edges;

    static void preOrder(String key) {
        String[] edge = edges.get(key);
        String left = edge[0];
        String right = edge[1];

        result.append(key);
        if (!left.equals(".")) {
            preOrder(left);
        }
        if (!right.equals(".")) {
            preOrder(right);
        }
    }
    static void inOrder(String key) {
        String[] edge = edges.get(key);
        String left = edge[0];
        String right = edge[1];

        if (!left.equals(".")) {
            inOrder(left);
        }
        result.append(key);
        if (!right.equals(".")) {
            inOrder(right);
        }
    }
    static void postOrder(String key) {
        String[] edge = edges.get(key);
        String left = edge[0];
        String right = edge[1];

        if (!left.equals(".")) {
            postOrder(left);
        }
        if (!right.equals(".")) {
            postOrder(right);
        }
        result.append(key);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edges = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            edges.put(arr[0], new String[]{arr[1], arr[2]});
        }

        result = new StringBuilder();
        preOrder("A");
        System.out.println(result);

        result = new StringBuilder();
        inOrder("A");
        System.out.println(result);

        result = new StringBuilder();
        postOrder("A");
        System.out.println(result);
    }
}