import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.println("Введіть число (або 'q' для завершення): ");
            String input = scanner.nextLine();

            if ("q".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Некоректний ввід. Будь ласка, введіть число або 'q' для завершення.");
            }
        }

        System.out.println("a. Сума всіх парних чисел: " + numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum());

        System.out.println("b. Результат множення кожного числа на 2: ");
        numbers.stream().map(n -> n * 2).forEach(System.out::println);

        System.out.println("c. Максимальне число у списку: " + numbers.stream().max(Integer::compareTo).orElse(0));

        System.out.println("d. Непарні числа у вигляді рядка, розділені комою: " +
                numbers.stream().filter(n -> n % 2 != 0).map(Object::toString).collect(Collectors.joining(", ")));

        System.out.println("e. Середнє арифметичне всіх чисел: " +
                numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0));
    }
}
