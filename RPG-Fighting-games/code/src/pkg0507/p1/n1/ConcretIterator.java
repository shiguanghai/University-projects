package pkg0507.p1.n1;

public class ConcretIterator implements TVIterator{
    private ConcretAggregate concretAggregate;

    private boolean first = false;
    private boolean last = false;

    private int channel = 0;
    private int maxChannel;

    public ConcretIterator(int maxChannel) {
        this.maxChannel = maxChannel;
        channel = maxChannel;
    }


    public void previous() {

        if(channel < 0){
            setFirst(true);
            channel = maxChannel;
        } else {
            setFirst(false);
        }

        if(!isFirst()){
            System.out.println("You're watching the channel "+this.channel+"!");
            setChannel(--channel);
        }

    }

    public void next() {
        if(channel > maxChannel){
            setLast(true);
            channel = 0;
        } else {
            setLast(false);
        }

        if(!isLast()){
            System.out.println("You're watching the channel "+this.channel+"!");
            setChannel(++channel);
        }
    }


    public void setChannel(int i) {
        channel = i;
    }


    public Object currentChannel() {
        return this.channel;
    }


    public void setLast(boolean last){
        this.last = last;
    }

    public boolean isLast() {
        return this.last;
    }

    public void setFirst(boolean first){
        this.first = first;
    }

    public boolean isFirst() {
        return this.first;
    }


}
