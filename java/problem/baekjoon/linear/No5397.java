package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5397 {
    static class KeyLogger {
        static final char LEFT = '<', RIGHT = '>', BACK = '-';
        char[] frontStack;
        char[] backStack;
        int frontTop;
        int backTop;
        String keyLog;

        public KeyLogger(String keyLog) {
            this.frontStack = new char[keyLog.length()];
            this.backStack = new char[keyLog.length()];
            this.frontTop = -1;
            this.backTop = -1;
            this.keyLog = keyLog;
        }

        public String getPassword() {
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < keyLog.length(); i++) {
                char key = keyLog.charAt(i);
                if (key == LEFT) {
                    if (frontTop >= 0) {
                        backStack[++backTop] = frontStack[frontTop--];
                    }
                } else if (key == RIGHT) {
                    if (backTop >= 0) {
                        frontStack[++frontTop] = backStack[backTop--];
                    }
                } else if (key == BACK) {
                    frontTop = Math.max(-1, frontTop - 1);
                } else {
                    frontStack[++frontTop] = key;
                }
            }

            for (int i = 0; i <= frontTop; i++) {
                password.append(frontStack[i]);
            }
            for (int i = backTop; i >= 0; i--) {
                password.append(backStack[i]);
            }
            return password.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder passwords = new StringBuilder();

        for (int i = 0; i < t; i++) {
            KeyLogger keyLogger = new KeyLogger(br.readLine());
            passwords.append(keyLogger.getPassword()).append("\n");
        }

        System.out.print(passwords);
    }

}
