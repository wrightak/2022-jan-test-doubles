package missile;

public class MissileLauncher {
    static void launchMissile(Missile missile, LaunchCode launchCode) {
        if (!launchCode.isExpired()) {
            missile.launch();
        }
    }
}
