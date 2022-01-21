package smarthome;

public class AlwaysOnSwitch implements Switch {
    @Override
    public boolean isOn() {
        return true;
    }
}
