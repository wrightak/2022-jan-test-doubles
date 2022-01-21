package missile;

import java.util.HashSet;

public class FakeUsedLaunchCodes implements UsedLaunchCodes {
    private HashSet<LaunchCode> set = new HashSet<>();

    @Override
    public void add(LaunchCode launchCode) {
        set.add(launchCode);
    }

    @Override
    public boolean contains(LaunchCode launchCode) {
        return set.contains(launchCode);
    }
}
