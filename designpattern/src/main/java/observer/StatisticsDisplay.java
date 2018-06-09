package observer;

import observer.subject.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {
    private Subject subject;
    private float humidity;
    private float temperature;
    private float pressure;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + " with " + humidity
                + " and " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        this.temperature = temp;
        this.pressure = pressure;
        display();
    }
}
