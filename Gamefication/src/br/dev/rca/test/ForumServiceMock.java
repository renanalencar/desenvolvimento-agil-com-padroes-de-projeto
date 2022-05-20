/**
 * 
 */
package br.dev.rca.test;

import br.dev.rca.ForumService;

/**
 * @author renanalencar
 *
 */
public class ForumServiceMock implements ForumService {

	public void failAddTopic(String user, String topic) {
		throw new RuntimeException();

	}

	@Override
	public void addTopic(String user, String topic) {

	}

	@Override
	public void addComment(String user, String topic, String comment) {

	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {

	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {

	}

}
