public class Radio implements Controllable, Sellable{
    public static final double RADIO_PRICE = 50.;
    public static final int MAX_FREQ = 1079;
    public static final int MIN_FREQ = 875;

    protected int station;

    public Radio() {
        reset();
    }

    @Override
    public void reset() {
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
    public String getDescription() {
        return "A Radio";
    }

    @Override
    public double getPrice() {
        return RADIO_PRICE;
    }

    @Override
    public String toString() {
        return Double.toString(station / 10.);
    }
}