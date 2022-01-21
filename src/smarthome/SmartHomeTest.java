package smarthome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartHomeTest {
    @Test
    public void turnBulbOn_whenSwitchIsOn() {
        BulbSpy bulbSpy = new BulbSpy();
        AlwaysOnSwitch alwaysOnSwitch = new AlwaysOnSwitch();

        SmartHome.run(bulbSpy, alwaysOnSwitch);

        assertTrue(bulbSpy.turnOnWasCalled());
        assertFalse(bulbSpy.turnOffWasCalled());
    }

    @Test
    public void turnBulbOff_whenSwitchIsOff() {
        BulbSpy bulbSpy = new BulbSpy();
        AlwaysOffSwitch alwaysOffSwitch = new AlwaysOffSwitch();

        SmartHome.run(bulbSpy, alwaysOffSwitch);

        assertTrue(bulbSpy.turnOffWasCalled());
        assertFalse(bulbSpy.turnOnWasCalled());
    }
}
