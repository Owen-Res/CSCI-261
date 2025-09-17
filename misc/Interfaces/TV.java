public class TV implements Controllable {
    public static final int MAX_VOL = 20;
    protected int volume = 0;
    protected boolean muted = false;

    public TV() {
        // default constructor
    }

    public void mute() {
        muted = !muted;
    }

    @Override
    public void reset() {
        mute();
    }

    @Override
    public void up() {
        volume = Math.min(volume + 1, MAX_VOL);
    }

    @Override
    public void down() {
        volume = Math.max(volume - 1, 0);
    }

    public String toString() {
        if (muted)
            return "mute";

        String result = "|".repeat(volume);
        result += ".".repeat(MAX_VOL - volume);
        return String.format("(%d/%d): %s", volume, MAX_VOL, result);
    }
}