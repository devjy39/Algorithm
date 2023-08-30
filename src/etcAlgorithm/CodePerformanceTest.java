package etcAlgorithm;

public class CodePerformanceTest {

    static void methodTest() {
        long start = System.nanoTime();
        // logic
        for (int i = 0; i < 10_000_000; i++) {
            int spendTime = (int) Math.ceil((float) i + 10 / (i + 1));
        }
        //
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    static void methodTest2() {
        long start = System.nanoTime();
        // logic
        for (int i = 0; i < 10_000_000; i++) {
            int time = (i + 10 + i + 1 - 1) / (i + 1);
        }

        //
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    static long methodTestStart() {
        return System.nanoTime();
    }

    static long methodTestEnd(long start) {
        return start - System.nanoTime();
    }

    public static void main(String[] args) {
        methodTest();
        methodTest2();
    }
}
