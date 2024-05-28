package practice.lambda;

/*
 *   람다 호출 시 invokedynamic 을 확인하고
 *   익명클래스와 람다가 내부적으로 다르게 처리됨을 확인한다.
 *
 *   람다는 내부적으로 해당 메서드를 캡처하여 lambda&...$... 포멧의 이름을 가진 프라이빗 메서드로 생성된다.
 *   해당 메서드가 methodhandle을 통해 invokedynamic 명령에 참조되며 런타임에 동적 바인딩된다.
 * */
public class LambdaTest {
    String hello = "hello";

    public void test() {
        Runnable instance = () -> {
            System.out.println("hi " + hello);
        };

        instance.run();
    }
    public static void main(String[] args) {
        new LambdaTest().test();
    }

}
