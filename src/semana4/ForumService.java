package semana4;

public interface ForumService {
	public abstract void addTopic(String user, String topic);
	public abstract void addComment(String user, String topic, String comment);
	public abstract void likeTopic(String user, String topic, String topicUser);
	public abstract void likeComment(String user, String topic, 
			String comment, String commentUser); 	

}
