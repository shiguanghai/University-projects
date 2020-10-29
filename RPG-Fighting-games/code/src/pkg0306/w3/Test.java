package pkg0306.w3;

public class Test {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        StaticsDisplay staticsDisplay = new StaticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        NewDisplay newDisplay = new NewDisplay();

        data.register(currentDisplay);
        data.register(staticsDisplay);
        data.register(forecastDisplay);

        data.measurementsChanged();
    }
}
