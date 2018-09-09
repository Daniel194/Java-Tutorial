package behavior.observer;

import java.util.Observable;

class WeatherData extends Observable {
    private float humidity;
    private float temperature;
    private float pressure;

    private void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    float getHumidity() {
        return humidity;
    }

    float getTemperature() {
        return temperature;
    }

    float getPressure() {
        return pressure;
    }
}
