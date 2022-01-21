package missile;

import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;

class MissileLauncherTest {
    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched() {
        launchMissile(new DummyMissile(), new ExpiredLaunchCode());
    }

}
