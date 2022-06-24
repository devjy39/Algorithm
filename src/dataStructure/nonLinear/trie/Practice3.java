package dataStructure.nonLinear.trie;
// Practice3
// 문자열 배열 strs 와 targets 가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs 중의 단어가 되는지 판별하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 strs: "apple", "banana", "kiwi"
// 입력 target: "applk", "bpple", "apple"
// 출력: true, true, false

public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        for (String target : targets) {
            System.out.print(examineWord(trie.root, target, 0, false)+" ");
        }
    }

    public static boolean examineWord(Node node, String target, int i, boolean flag){
        if (target.length() == i) {
            return flag && node.isTerminal;
        }

        return node.child.keySet().stream().anyMatch(
                key -> key == target.charAt(i) ? examineWord(node.child.get(key), target, i + 1, flag)
                        : !flag && examineWord(node.child.get(key), target, i + 1, true));
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"apple", "banana", "kiwi", "appzz"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets);    // true, true, false, false, true
    }
}
