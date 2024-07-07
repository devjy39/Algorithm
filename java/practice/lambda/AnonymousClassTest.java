package practice.lambda;

public class AnonymousClassTest {
    public static void main(String[] args) {
        Runnable anonymousClassInstance = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };

        anonymousClassInstance.run();
    }

}
