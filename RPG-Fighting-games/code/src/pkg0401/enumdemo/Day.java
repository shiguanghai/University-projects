package pkg0401.enumdemo;

public class Day {
    private String day;
    private Week week;

    public Day(String day,Week week){
        super();
        this.day=day;
        this.week=week;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day='" + day + '\'' +
                ", week=" + week +
                '}';
    }
}
