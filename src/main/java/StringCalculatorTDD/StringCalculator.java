package main.java.StringCalculatorTDD;
 import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\n";
        String numbersWithoutDelimiterDeclaration = numbers;

        if (numbers.startsWith("//")) {
            delimiter = Character.toString(numbers.charAt(2));
            numbersWithoutDelimiterDeclaration = numbers.substring(numbers.indexOf('\n') + 1);
        }

        String[] nums = numbersWithoutDelimiterDeclaration.split(delimiter);
        int sum = 0;

        List<Integer> negativeNumbers = new ArrayList<>();

        for (String num : nums) {
            int n = Integer.parseInt(num);

            if (n < 0) {
                negativeNumbers.add(n);
            }

            sum += n;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
