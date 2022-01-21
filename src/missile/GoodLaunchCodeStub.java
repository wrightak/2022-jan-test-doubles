package missile;

public class GoodLaunchCodeStub implements LaunchCode {
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isSigned() {
        return true;
    }
}
