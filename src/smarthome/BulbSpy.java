package smarthome;

public class BulbSpy implements Bulb {
    private boolean turnOnWasCalled = false;
    private boolean turnOffWasCalled = false;

    @Override
    public void turnOn() {
        turnOnWasCalled = true;
    }

    @Override
    public void turnOff() {
        turnOffWasCalled = true;
    }

    public boolean turnOnWasCalled() {
        return turnOnWasCalled;
    }

    public boolean turnOffWasCalled() {
        return turnOffWasCalled;
    }
}
