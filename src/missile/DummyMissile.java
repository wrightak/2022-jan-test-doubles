package missile;

public class DummyMissile implements Missile {
    @Override
    public void launch() {
        throw new RuntimeException();
    }
}
