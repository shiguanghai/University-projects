package pkg0306.w1;

public class WeatherData {
	//instance vaiavle declearatione

	private CurrentDisplay currentDisplay = new CurrentDisplay();
	private StaticsDisplay staticsDisplay = new StaticsDisplay();
	private ForecastDisplay forecastDisplay = new ForecastDisplay();

	//����3�������ӵ����������ṩ�����������
	public double getTemperature() {//get temperature from weather station
		return -10+(int)(Math.random()*51);//ģ��һ������¶�
	}
	public double getHumidity() {//get Humidity from weather station
		return (int)(Math.random()*101);//ģ��һ�����ʪ��
	}
	public double getPressure() {//get Pressure from weather station
		return 1000+(int)(Math.random()*1001);//ģ��һ�������ѹ��
	}

	public void measurementsChanged() {
		double temp = getTemperature();
		double humidity = getHumidity();
		double pressure = getPressure();

		currentDisplay.update(temp, humidity, pressure);
		staticsDisplay.update(temp, humidity, pressure);
		forecastDisplay.update(temp, humidity, pressure);
	}

	//other WeatherDate methods here
}
