public class Radio implements Controllable{
    public static final int MAX_FREQ = 1079;
    public static final int MIN_FREQ = 875;

    protected int station;

    public Radio(){
        reset();
    }
    @Override
    public void reset(){
        station = MIN_FREQ;
    }

    @Override
    public void up() {
       station = Math.clamp(station + 1, MIN_FREQ, MAX_FREQ);
    }

    @Override
    public void down() {
        station = Math.clamp(station - 1, MIN_FREQ, MAX_FREQ);
    }

    @Override
    public String toString(){
        return Double.toString(station/10.);
    }
}