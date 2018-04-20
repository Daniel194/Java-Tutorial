import java.util.ArrayList;
import java.util.List;

public class Generic {

    public static void main(String... args) {
        fly1(new ArrayList<Flyer>());
        fly1(new ArrayList<>());
        fly1(new ArrayList<Goose>());

        fly2(new ArrayList<Flyer>());
        fly2(new ArrayList<>());
        //fly2(new ArrayList<Goose>()); // DOES NOT COMPILE
    }


    private static void fly1(List<? extends Flyer> list) {

    }

    private static void fly2(List<Flyer> list) {

    }

    <T> T method1(List<? extends T> list) {
        return list.get(0);
    }

}

interface Flyer {

}

class Goose implements Flyer {

}