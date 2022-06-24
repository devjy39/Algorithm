package dataStructure.math.practice2;

public class Practice2 {
    public static int solution(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;
        boolean isSimilar = false;

        while (leftIndex <= rightIndex) {
            char left = str.charAt(leftIndex);
            char right = str.charAt(rightIndex);
            if (left != right) {
                if (str.charAt(leftIndex + 1) == right && !isSimilar) {
                    isSimilar = true;
                    leftIndex++;
                } else if (str.charAt(rightIndex - 1) == left && !isSimilar) {
                    isSimilar = true;
                    rightIndex--;
                } else {
                    return 2;
                }
            }
            leftIndex++;
            rightIndex--;
        }

        return isSimilar ? 1 : 0;
    }

    //재귀
    public static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        if (left > right) {
            return Math.min(delCnt,2);
        }

        if (arr[left] == arr[right]) {
            return isPalindrome(left + 1, right - 1, arr, delCnt);
        } else {
            if (arr[left + 1] == arr[right]) {
                return isPalindrome(left + 1, right, arr, delCnt+1);
            } else if (arr[left] == arr[right - 1]) {
                return isPalindrome(left, right - 1, arr, delCnt + 1);
            }
        }

        return 2;
    }

    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));

        System.out.println("----------------------");
        for (String s : str) {
            System.out.println(isPalindrome(0,s.length()-1,s.toCharArray(),0));
        }
    }
}
