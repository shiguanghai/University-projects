package pkg0422.n1;

public abstract class GetTime {
    public abstract void runcode();
    public final void getTimeProcess(){
        long start = System.currentTimeMillis();
        runcode();
        long end = System.currentTimeMillis();
        System.out.println("≥Ã–Ú‘À––∫¡√Î="+(end-start));
    }
}
