package pkg0401.enumdemo;

public class Week {
    private int value;
    public static final Week MON = new Week(0);
    public static final Week TUE = new Week(1);
    public static final Week WED = new Week(2);
    public static final Week THU = new Week(3);
    public static final Week FRI = new Week(4);
    public static final Week SAT = new Week(5);
    public static final Week SUN = new Week(6);

    public Week(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        switch (value){
            case 0: return "星期一";
            case 1: return "星期二";
            case 2: return "星期三";
            case 3: return "星期四";
            case 4: return "星期五";
            case 5: return "星期六";
            case 6: return "星期日";
            default: return null;
        }
    }

}
