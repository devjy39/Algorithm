package dataStructure.nonLinear.trie;
// Practice1
// 문자열 배열 strs 와 문자열 prefix 가 주어졌을 때
// 문자열 배열 내에 prefix 로 시작하는 단어가 있는지를 확인하는 프로그램을 작성하세요.
// prefix 로 시작하는 단어가 있으면 true, 없으면 false 를 반환하세요.

// 입출력 예시
// 입력 strs: "apple", "april", "app", "ace", "bear", "best"
// 입력 prefix: "app"
// 출력: true

// 입력 strs: "apple", "april", "app", "ace", "bear", "best"
// 입력 prefix: "pre"
// 출력: false



public class Practice1 {
    public static boolean solution(String[] strs, String prefix) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        Node node = trie.root;
        for (char c : prefix.toCharArray()) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"apple", "april", "app", "ace", "bear", "best"};
        String prefix = "app";
        System.out.println(solution(strs, prefix)); // true

        prefix = "be";
        System.out.println(solution(strs, prefix)); // true

        prefix = "pre";
        System.out.println(solution(strs, prefix)); // false
    }
}
