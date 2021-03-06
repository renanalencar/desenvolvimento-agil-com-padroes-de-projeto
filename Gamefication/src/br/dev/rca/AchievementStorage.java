package br.dev.rca;

import java.util.List;

/**
 * @author renanalencar
 *
 */
public interface AchievementStorage {

	public void addAchievement(String user, Achievement a);

	public List<Achievement> getAchievements(String user);

	public Achievement getAchievement(String user, String achievementName);
	
	public void addObserver(AchievementObserver observer);
}
