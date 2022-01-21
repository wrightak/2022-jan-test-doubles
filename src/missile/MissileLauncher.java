package missile;

public class MissileLauncher {
    static void launchMissile(Missile missile, LaunchCode launchCode, UsedLaunchCodes usedLaunchCodes) {
        if (launchCode.isExpired() ||
                !launchCode.isSigned() ||
                usedLaunchCodes.contains(launchCode)) {
            missile.disable();
            return;
        }
        usedLaunchCodes.add(launchCode);
        missile.launch();
    }
}
