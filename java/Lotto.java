import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    List<Integer> numbers;

    public Lotto() {
        this.numbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());
    }

    public String getGames(int n) {
        StringBuilder result = new StringBuilder();

        int[] randomNumbers = new int[6];

        for (int i = 0; i < n; i++) {
            Collections.shuffle(numbers);

            for (int j = 0; j < 6; j++) {
                randomNumbers[j] = numbers.get(j);
            }
            Arrays.sort(randomNumbers);

            for (int randomNumber : randomNumbers) {
                result.append(randomNumber).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Lotto lotto = new Lotto();

        System.out.println(lotto.getGames(5));
    }
}
