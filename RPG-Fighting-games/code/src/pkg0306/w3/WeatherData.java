package pkg0306.w3;

public class WeatherData extends Subject {
    //以下3个方法从第三方数据提供方，获得数据
    public double getTemperature() {//get temperature from weather station
        return -10+(int)(Math.random()*51);//模拟一个随机温度
    }
    public double getHumidity() {//get Humidity from weather station
        return (int)(Math.random()*101);//模拟一个随机湿度
    }
    public double getPressure() {//get Pressure from weather station
        return 1000+(int)(Math.random()*1001);//模拟一个随机气压数
    }

    public void measurementsChanged(){
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();

        notifyObservers(temp, humidity, pressure);
    }
}
