package observer;

import observer.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Subject subject;
    private float humidity;
    private float temperature;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + " with " + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        this.temperature = temp;
        display();
    }
}
