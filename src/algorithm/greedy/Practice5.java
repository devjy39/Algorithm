package algorithm.greedy;
// Practice
// 정수 num 이 주어졌을 때,
// num 숫자에서 두 자리를 최대 한번만 교체하여 얻을 수 있는 최대값을 출력하세요.

// 입출력 예시
// num: 2736
// 출력: 7236

// 입력: 7116
// 출력: 7611

public class Practice5 {
    public static int solution(int num) {
        String str = String.valueOf(num);
        char[] cArr = str.toCharArray();
        int[] maxArr = new int[cArr.length];

        int max = 0;
        for (int i = cArr.length - 1; i >= 0; i--) {
            max = Math.max(max, cArr[i] - '0');
            maxArr[i] = max;
        }

        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] != cArr[i] - '0') {
                for (int j = cArr.length - 1; j > i; j--) {
                    if (maxArr[i] == cArr[j] - '0') {
                        char temp = cArr[j];
                        cArr[j] = cArr[i];
                        cArr[i] = temp;
                        break;
                    }
                }
                break;
            }
        }

        return Integer.parseInt(String.valueOf(cArr));
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
    }
}
