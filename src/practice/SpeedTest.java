package practice;

public class SpeedTest {

    private static final double NANO = 1_000_000_000.0;
    static final int YEAR = 2023, MONTH = 1;


    private double getMethodSpeed(DaysInterface daysInterface, int repeatCycle, int repeatCount) {
        double totalTime = 0;

        for (int i = 0; i < repeatCycle; i++) {
            totalTime += getNanoTime(daysInterface, repeatCount);
        }

        return totalTime / repeatCycle;
    }

    private static double getNanoTime(DaysInterface daysInterface, int repeatCount) {
        long start = System.nanoTime();

        for (int i = 0; i < repeatCount; i++) {
            daysInterface.getDays(YEAR, MONTH);
        }

        long end = System.nanoTime();

        return (double) (end - start) / NANO;
    }


    public static void main(String[] args) {
        SpeedTest speedTest = new SpeedTest();

        DaysInterface sampleCode = new SampleDays();
        DaysInterface arrayCode = new ArrayDays();
        DaysInterface hashMapCode = new HashMapDays();

        int repeatCycle = 1000;
        int repeatCount = 10_000_000;

        speedTest.warmUp(speedTest);
        System.out.println("hashMap Code : " + speedTest.getMethodSpeed(hashMapCode, repeatCycle, repeatCount) + "s");
        System.out.println("array Code : " + speedTest.getMethodSpeed(arrayCode, repeatCycle, repeatCount) + "s");
        System.out.println("sample Code : " + speedTest.getMethodSpeed(sampleCode, repeatCycle, repeatCount) + "s");
    }

    private void warmUp(SpeedTest speedTest) {
        speedTest.getMethodSpeed(new SampleDays(), 10000, 100_000_000);
    }
}
