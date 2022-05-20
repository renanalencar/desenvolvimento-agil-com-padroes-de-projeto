/**
 * 
 */
package br.dev.rca;

/**
 * @author renanalencar
 *
 */
public class ForumServiceGamificationProxy implements ForumService {

	private ForumService forumService;
	private AchievementStorage achivementStorage;

	public ForumServiceGamificationProxy(ForumService forumService) {
		this.forumService = forumService;
		this.achivementStorage = AchievementStorageFactory.getAchievementStorage();
	}

	@Override
	public void addTopic(String user, String topic) {
		this.forumService.addTopic(user, topic);
		this.achivementStorage.addAchievement(user, new Points("CREATION", 5));
		this.achivementStorage.addAchievement(user, new Badge("I CAN TALK"));
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		this.forumService.addComment(user, topic, comment);
		this.achivementStorage.addAchievement(user, new Points("PARTICIPATION", 3));
		this.achivementStorage.addAchievement(user, new Badge("LET ME ADD"));
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		this.forumService.likeComment(topicUser, topic, topicUser, user);
		this.achivementStorage.addAchievement(user, new Points("CREATION", 1));
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		this.forumService.likeComment(user, topic, comment, commentUser);
		this.achivementStorage.addAchievement(user, new Points("PARTICIPATION", 1));
	}

}
