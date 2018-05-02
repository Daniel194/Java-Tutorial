import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static void main(String... args) {
        List<String> fields = getFieldNames(new Person());
        fields.forEach(System.out::println);
    }

    private static List<String> getFieldNames(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

}


class Person {
    private String name;
    private int age;
}