package missile;

import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MissileLauncherTest {
    @Test
    public void givenGoodLaunchCodes_MissileIsLaunched() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new GoodLaunchCodeStub(), new FakeUsedLaunchCodes());

        assertTrue(missileSpy.launchWasCalled());
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_dummy() {
        launchMissile(new DummyMissile(), new ExpiredLaunchCodeStub(), new FakeUsedLaunchCodes());
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_spy() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new ExpiredLaunchCodeStub(), new FakeUsedLaunchCodes());

        assertFalse(missileSpy.launchWasCalled());
    }

    @Test
    public void givenExpiredLaunchCodes_CodeRedAbort_spy() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new ExpiredLaunchCodeStub(), new FakeUsedLaunchCodes());

        assertFalse(missileSpy.launchWasCalled());
        assertTrue(missileSpy.disableWasCalled());
    }

    @Test
    public void givenUnsignedLaunchCodes_CodeRedAbort_spy() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new UnsignedLaunchCodeStub(), new FakeUsedLaunchCodes());

        assertFalse(missileSpy.launchWasCalled());
        assertTrue(missileSpy.disableWasCalled());
    }

    @Test
    public void givenExpiredLaunchCodes_CodeRedAbort_mock() {
        MissileMock missileMock = new MissileMock();

        launchMissile(missileMock, new ExpiredLaunchCodeStub(), new FakeUsedLaunchCodes());

        missileMock.verifyCodeRedAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_CodeRedAbort_mock() {
        MissileMock missileMock = new MissileMock();

        launchMissile(missileMock, new UnsignedLaunchCodeStub(), new FakeUsedLaunchCodes());

        missileMock.verifyCodeRedAbort();
    }

    @Test
    void useLaunchCodeTwice_CodeRedAbort() {
        MissileMock missileMock1 = new MissileMock();
        MissileMock missileMock2 = new MissileMock();
        GoodLaunchCodeStub goodLaunchCode = new GoodLaunchCodeStub();
        FakeUsedLaunchCodes fakeUsedLaunchCodes = new FakeUsedLaunchCodes();

        launchMissile(missileMock1, goodLaunchCode, fakeUsedLaunchCodes);
        launchMissile(missileMock2, goodLaunchCode, fakeUsedLaunchCodes);

        missileMock2.verifyCodeRedAbort();
    }
}
