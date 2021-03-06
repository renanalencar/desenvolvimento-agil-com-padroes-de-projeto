/**
 * 
 */
package br.dev.rca;

/**
 * @author renanalencar
 *
 */
public class CreationPointsObserver implements AchievementObserver {

	private final String pointName = "CREATION";
	private final String badgeName = "INVENTOR";

	@Override
	public void achievementUpdate(String user, Achievement a) {
		if (a.getName() == this.pointName && ((Points) a).getAmount() == 100) {
			AchievementStorage as = AchievementStorageFactory.getAchievementStorage();
			if (as.getAchievement(user, badgeName) != null) {
				as.addAchievement(user, new Badge(badgeName));
			}
		}
	}

}
