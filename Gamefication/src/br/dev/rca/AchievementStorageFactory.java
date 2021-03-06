package br.dev.rca;

/**
 * @author renanalencar
 */
public class AchievementStorageFactory {

	private static AchievementStorage as = null;

	public static void setAchievementStorage(AchievementStorage a) {
		as = a;
	}

	public static AchievementStorage getAchievementStorage() {
		if (as == null) {
			AchievementStorage achievementStorage = new MemoryAchievementStorage();
			setAchievementStorage(achievementStorage);
		}
		return as;
	}
}