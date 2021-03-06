package br.dev.rca.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.dev.rca.Achievement;
import br.dev.rca.AchievementStorageFactory;
import br.dev.rca.CreationPointsObserver;
import br.dev.rca.ForumServiceGamificationProxy;
import br.dev.rca.MemoryAchievementStorage;
import br.dev.rca.ParticipationPointsObserver;
import br.dev.rca.Points;

/**
 * @author renanalencar
 *
 */
class ForumServiceGamificationProxyTest {

	private MemoryAchievementStorage memoryAchievementStorage;
	private ForumServiceGamificationProxy proxy;
	private ForumServiceMock mockService;

	@Before
	void setUp() throws Exception {
		this.memoryAchievementStorage = new MemoryAchievementStorage();
		this.memoryAchievementStorage.addObserver(new CreationPointsObserver());
		this.memoryAchievementStorage.addObserver(new ParticipationPointsObserver());
		
		AchievementStorageFactory.setAchievementStorage(memoryAchievementStorage);

		this.mockService = new ForumServiceMock();
		this.proxy = new ForumServiceGamificationProxy(mockService);
	}

	@Test
	void testAddTopic() {
		this.proxy.addTopic("Mario", "It's me, Mario!");
		Points points = (Points) this.memoryAchievementStorage.getAchievement("Mario", "CREATION");
		assertEquals(5, points.getAmount());
	}

	@Test
	void testAddComment() {
		this.proxy.addTopic("Luigi", "Here we go!");
		this.proxy.addComment("Mario", "Here we go!", "Mama mia!");

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Mario", "PARTICIPATION");

		assertEquals(3, points.getAmount());
	}

	@Test
	void testLikeTopic() {
		proxy.addTopic("Luigi", "Madonna mia!");
		proxy.likeTopic("Mario", "Madonna mia!", "Luigi");

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Mario", "CREATION");

		assertEquals(1, points.getAmount());
	}

	@Test
	void testLikeComment() {
		proxy.addTopic("Luigi", "Dio mio!");
		proxy.addComment("Mario", "Dio mio!", "I like this.");
		proxy.likeComment("Toad", "Dio mio!", "I like this.", "Mario");

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Toad", "PARTICIPATION");

		assertEquals(1, points.getAmount());
	}

	@Test
	void testAddTopicTwice() {
		proxy.addTopic("Toad", "Hi, folks!");
		proxy.addTopic("Toad", "Hello, Pricess Peach!");

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Toad", "CREATION");

		assertEquals(10, points.getAmount());
	}

	@Test
	void testInvokingSerevalMethods() {
		proxy.addTopic("Browser", "Hello world!");
		proxy.addTopic("Browser", "Hello galaxy!");
		proxy.likeTopic("Browser", "Hello world", "Hi there!");
		proxy.likeTopic("Browser", "Hello world", "Hello!");
		proxy.likeTopic("Browser", "Hello world", "Hoorray!");

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Browser", "CREATION");

		assertEquals(13, points.getAmount());
	}

	@Test
	void testMockException() {
		assertThrows(RuntimeException.class, () -> this.proxy.addTopic("Mario", "Bye!"));
	}

	@Test
	void testWhenHundredPointsCreationGetBadgeInventor() {
		for (int i = 0; i < 20; i++) {
			proxy.addTopic("Luigi", "Come on, Mario " + i);
		}

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Luigi", "CREATION");
		Achievement badge = this.memoryAchievementStorage.getAchievement("Luigi", "I CAN TALK");
		Achievement anotherBadge = this.memoryAchievementStorage.getAchievement("Luigi", "INVENTOR");

		assertEquals(100, points.getAmount());
		assertEquals("I CAN TALK", badge.getName());
		assertEquals("INVENTOR", anotherBadge.getName());
	}

	@Test
	void testWhenHundredPointsParticipationGetBadgePartOfTheCommunity() {
		proxy.addTopic("Toad", "Hi, there!");
		for (int i = 0; i < 34; i++) {
			proxy.addComment("Toad", "Hi, there!", "Hi!");
		}

		Points points = (Points) this.memoryAchievementStorage.getAchievement("Toad", "PARTICIPATION");
		Achievement badge = this.memoryAchievementStorage.getAchievement("Toad", "PART OF THE COMMUNITY");

		assertEquals(102, points.getAmount());
		assertEquals("PART OF THE COMMUNITY", badge.getName());
	}

}
