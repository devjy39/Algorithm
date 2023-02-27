package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1406 {
    static class Editor {
        int n;
        Stack<Character> leftStack;
        Stack<Character> rightStack;

        public Editor(String str) {
            this.n = str.length();
            init(str);
        }

        public void init(String str) {
            leftStack = new Stack<>();
            rightStack = new Stack<>();

            for (int i = 0; i < n; i++) {
                leftStack.push(str.charAt(i));
            }
        }

        public void moveLeft() {
            if (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }

        public void moveRight() {
            if (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
        }

        public void removeText() {
            if (!leftStack.isEmpty()) {
                leftStack.pop();
            }
        }

        public void addText(char text) {
            leftStack.push(text);
        }

        public String getString() {
            StringBuilder sb = new StringBuilder();
            for (Character text : leftStack) {
                sb.append(text);
            }
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Editor editor = new Editor(br.readLine());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    editor.moveLeft();
                    break;
                case 'D':
                    editor.moveRight();
                    break;
                case 'B':
                    editor.removeText();
                    break;
                case 'P':
                    editor.addText(command.charAt(2));
            }
        }

        System.out.println(editor.getString());
    }

}