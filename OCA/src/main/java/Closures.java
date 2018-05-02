import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Closures {

    public static void main(String... args) {
        Map<String, Supplier> v = createCounterOk(42);
        v.get("val").get(); // returns 42
        v.get("inc").get(); // returns 42
        v.get("val").get(); // returns 43
    }

    private static void ok() {
        int myVar = 42;
        Supplier<Integer> lambdaFun = () -> myVar; // ok
        System.out.println(lambdaFun.get());
    }


    private static void error1() {
        int myVar = 42;
        Supplier<Integer> lambdaFun = () -> myVar; // error
        myVar++;
        System.out.println(lambdaFun.get());
    }

    private static void error2() {
        int myVar = 42;
        Supplier<Integer> lambdaFun = () -> myVar++; // error
        System.out.println(lambdaFun.get());
    }

    public static Map<String, Supplier> createCounterError(int initValue) {
        Map<String, Supplier> counter = new HashMap<>();
        counter.put("val", () -> initValue); //ERROR
        counter.put("inc", () -> initValue++); //ERROR
        return counter;
    }

    public static Map<String, Supplier> createCounterOk(int initValue) {
        MyClosure closure = new MyClosure(initValue);
        Map<String, Supplier> counter = new HashMap<>();
        counter.put("val", () -> closure.value);
        counter.put("inc", () -> closure.value++);
        return counter;
    }

    private static class MyClosure {
        public int value;

        public MyClosure(int initValue) {
            this.value = initValue;
        }
    }

}
