public class UniversalRemote {
    private Controllable device;

    public UniversalRemote(Controllable d) {
        switchDevice(d);
    }

    public void switchDevice(Controllable d) {
        device = d;
    }

    public void pressDown() {
        device.down();

    }

    public void pressReset() {
        device.reset();
    }

    public void pressUp() {
       device.up();
    }
    
    @Override
    public String toString(){
        final String HEADER = "Remote Connected to device with data:\n";
        return HEADER + device.toString();
    }
}