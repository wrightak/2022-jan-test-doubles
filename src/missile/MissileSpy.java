package missile;

public class MissileSpy implements Missile {
    private boolean launchWasCalled = false;

    @Override
    public void launch() {
        launchWasCalled = true;
    }

    public boolean launchWasCalled() {
        return launchWasCalled;
    }
}
