package pkg0507.p1.n1;

public interface TVIterator {
    public abstract void previous();

    public abstract void next();

    public abstract void setChannel(int i);

    public abstract Object currentChannel();

    public abstract boolean isLast();

    public abstract boolean isFirst();

}
