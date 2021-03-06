package br.dev.rca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author renanalencar
 *
 */
public class MemoryAchievementStorage implements AchievementStorage {

	private Map<String, List<Achievement>> storage;
	private List<AchievementObserver> achievementObservers;

	public MemoryAchievementStorage() {
		this.storage = new HashMap<>();
		this.achievementObservers = new ArrayList<>();
	}

	@Override
	public void addAchievement(String user, Achievement a) {
		List<Achievement> achievements = this.storage.get(user);
		a.addTo(achievements);
		achievementObservers.forEach(observer -> observer.achievementUpdate(user, a));
	}

	@Override
	public List<Achievement> getAchievements(String user) {
		List<Achievement> achievements = this.storage.get(user);
		return achievements;
	}

	@Override
	public Achievement getAchievement(String user, String achievementName) {
		Achievement a = null;
		List<Achievement> achievements = this.storage.get(user);
		for (Achievement achievement : achievements) {
			if (achievement.getName().equals(achievementName)) {
				a = achievement;
			}
		}
		return a;
	}

	@Override
	public void addObserver(AchievementObserver observer) {
		achievementObservers.add(observer);
	}

}
