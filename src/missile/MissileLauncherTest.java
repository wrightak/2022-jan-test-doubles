package missile;

import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MissileLauncherTest {
    @Test
    public void givenGoodLaunchCodes_MissileIsLaunched() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new GoodLaunchCodeStub());

        assertTrue(missileSpy.launchWasCalled());
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_dummy() {
        launchMissile(new DummyMissile(), new ExpiredLaunchCodeStub());
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_spy() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new ExpiredLaunchCodeStub());

        assertFalse(missileSpy.launchWasCalled());
    }

}
