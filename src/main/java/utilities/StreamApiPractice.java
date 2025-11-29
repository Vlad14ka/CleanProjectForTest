package utilities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiPractice {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList(
                "Java", "Python", "C++", "JavaScript", "Kotlin",
                "Scala", "Ruby", "Java", "Python", "Go"
        );

        System.out.println("=== Промежуточные операции ===");

        // filter() - фильтрация
        System.out.println("1. Filter (длина > 4):");
        languages.stream()
                .filter(lang -> lang.length() > 4)
                .forEach(System.out::println);

        // map() - преобразование
        System.out.println("\n2. Map (to uppercase):");
        languages.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // distinct() - уникальные значения
        System.out.println("\n3. Distinct (уникальные):");
        languages.stream()
                .distinct()
                .forEach(System.out::println);

        // sorted() - сортировка
        System.out.println("\n4. Sorted (сортировка):");
        languages.stream()
                .sorted()
                .forEach(System.out::println);

        // limit() - ограничение количества
        System.out.println("\n5. Limit (первые 3):");
        languages.stream()
                .limit(3)
                .forEach(System.out::println);

        // skip() - пропуск элементов
        System.out.println("\n6. Skip (пропустить первые 2):");
        languages.stream()
                .skip(2)
                .forEach(System.out::println);

        // peek() - просмотр элементов (debug)
        System.out.println("\n7. Peek (debug):");
        languages.stream()
                .peek(lang -> System.out.println("Обрабатывается: " + lang))
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}