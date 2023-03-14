package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No1759 {
    static StringBuilder result = new StringBuilder();
    static Set<Character> vowelSet = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] passwords = new char[C];
        String str = br.readLine();
        for (int i = 0; i < C; i++) {
            passwords[i] = str.charAt(i * 2);
        }
        Arrays.sort(passwords);
        dfs(passwords, new boolean[C], 0, 0, 0, 0);

        System.out.print(result);
    }

    private static void dfs(char[] passwords, boolean[] check, int idx, int vowel, int consonant, int count) {
        if (count == L) {
            if (vowel >= 1 && consonant >= 2) {
                for (int j = 0; j < check.length; j++) {
                    if (check[j]) {
                        result.append(passwords[j]);
                    }
                }
                result.append("\n");
            }
            return;
        }else if (idx >= passwords.length) {
            return;
        }

        check[idx] = true;
        dfs(passwords, check, idx + 1, vowelSet.contains(passwords[idx]) ? vowel + 1 : vowel,
                vowelSet.contains(passwords[idx]) ? consonant : consonant + 1, count + 1);
        check[idx] = false;
        dfs(passwords, check, idx + 1, vowel, consonant, count);
    }

}
