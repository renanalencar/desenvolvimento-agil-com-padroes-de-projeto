/**
 * 
 */
package br.dev.rca;

/**
 * @author renanalencar
 *
 */
public class ParticipationPointsObserver implements AchievementObserver {

	private final String pointName = "PARTICIPATION";
	private final String badgeName = "PART OF THE COMMUNITY";

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
