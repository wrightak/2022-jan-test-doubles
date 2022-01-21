package smarthome;

public class SmartHome {
    static void run(Bulb bulb, Switch aSwitch) {
        if (aSwitch.isOn()) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}
