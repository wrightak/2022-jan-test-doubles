package smarthome;

public class AlwaysOffSwitch implements Switch {
    @Override
    public boolean isOn() {
        return false;
    }
}
