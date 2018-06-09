package observer;

import observer.subject.Subject;
import observer.subject.WeatherData;

public class ObserverPattern {

    public static void main(String... args) {
        WeatherData subject = new WeatherData();
        Observer ob1 = new CurrentConditionsDisplay(subject);
        Observer ob2 = new StatisticsDisplay(subject);

        subject.registerObserver(ob1);
        subject.registerObserver(ob2);

        subject.setMeasurements(10, 75, 1000);
        subject.setMeasurements(15, 35, 1020);
    }

}
