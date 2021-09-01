import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gitPractise {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        loadList(numbers, 20);

    }
    public static List<Integer> loadList(List<Integer> numbers, int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        int currentNumber = 0;
        for (int i = 0; i < 20; i++) {
            currentNumber = getRandomMinMax(1, 100);
            randomNumbers.add(currentNumber);
        }
        return randomNumbers;
    }

    public static int getRandomMinMax(int min, int max) {
        Random rnd = new Random();
        int random = rnd.nextInt(max + 1 - min) + min;
        return random;
    }

}
