package semana4;

public class ForumServiceGamificationProxy implements ForumService {

	private ForumService proxyEncapsulado;

	public ForumServiceGamificationProxy(ForumService forumServiceEncapsulado) {		
		this.proxyEncapsulado = forumServiceEncapsulado;
	}

	public void addTopic(String user, String topic) {
		proxyEncapsulado.addTopic(user, topic);
	}

	public void addComment(String user, String topic, String comment) {
		proxyEncapsulado.addComment(user, topic, comment);
	}

	public void likeTopic(String user, String topic, String topicUser) {
		proxyEncapsulado.likeTopic(user, topic, topicUser);
	}

	public void likeComment(String user, String topic, String comment,
			String commentUser) {
		proxyEncapsulado.likeComment(user, topic, comment, commentUser);
	}
		

}
