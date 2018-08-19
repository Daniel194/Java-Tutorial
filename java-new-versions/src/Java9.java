import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Java9 {

    public static void main(String... args) {

        // Factory Methods for Immutable List, Set, Map and Map.Entry
        List immutableList = List.of("one", "two", "three");
        Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");


        Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i < 5 )
                .forEach(System.out::println);

        Stream.of(1,2,3,4,5,6,7,8,9,10).dropWhile(i -> i < 5 )
                .forEach(System.out::println);

    }

}
