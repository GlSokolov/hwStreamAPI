import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

        Stream<Integer> stream = numbers.stream();
        Comparator<Integer> comparator = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> System.out.println("min: "+min+ "| max: " + max);
        findMinMax(stream, comparator, biConsumer);

        System.out.println("======================================");

        findEvenNumbers(numbers);

    }


    // Задание 1
    public static <T> void findMinMax (Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        } else {
            minMaxConsumer.accept(null, null);
        }



    }


    // Задание 2
    public static void findEvenNumbers (List<Integer> list){
        list.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }

}
