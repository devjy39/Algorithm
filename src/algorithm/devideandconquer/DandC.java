package algorithm.devideandconquer;
/*  합병 정렬,퀵 정렬, 이진 탐색 등이 여기 포함된다.
*   문제를 부분들로 분할해서 해답을 통합하여 답을 구한다.
*   병렬처리에 이점이 있음.
*   재귀 시 stack 메모리 많이 사용
*   핵심은 mid에서 연산이 투포인터라 mid가 포함된 영역을 다 가져가기 때문에
*   나머지 원소들은 범위가 반씩 줄어들기 때문에 이득을 보는것이고
*   O(N^2)이 O(NlogN)으로 줄어든다.!
*   보통은 mid연산에서 투포인터로 O(n)을 가져가야 큰 이득을 봄.
* */


public class DandC {
    public static int getMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        // 바텀업 방식으로 올라가기, 큰 의미에서 작업
        int mid = (left + right) >> 1;
        System.out.println(mid+" -> "+left+" "+right);
        int maxLeft = getMax(arr, left, (left + right) >> 1);
        int maxRight = getMax(arr, ((left + right) >> 1) + 1, right);

        return Math.max(maxLeft, maxRight);
    }


    public static void main(String[] args) {
        int arr[] = {6, 2, 9, 8, 1, 4, 17, 5};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
