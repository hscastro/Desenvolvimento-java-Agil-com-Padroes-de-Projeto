package semana4;

import java.util.ArrayList;
import java.util.List;

public class ForumServiceGamificationProxyMock implements ForumService {

	private List<Achievement> lista = new ArrayList<>();
	private Achievement achievement;
	private Points points;
	private Badge badge;
	private Usuario user;
	private int total;
	
	public ForumServiceGamificationProxyMock(Achievement tipoAchievement, String nome) {		
		this.total = 0;
		this.user = new Usuario(nome);			
		
		if(tipoAchievement.getAchievement() instanceof Points){			
			this.points = (Points) tipoAchievement;			
			this.points.setNome(this.points.getNome());		
			this.points.setUsuario(this.user);			
			this.badge = (Badge) points.getBadge();			
			this.achievement = this.points;		
			
		}else{			
			System.out.println("teste 2");
			this.achievement = tipoAchievement;	
			this.achievement.setUsuario(this.user);
			this.achievement.setNome(this.achievement.getNome());
		}		

	}

	@Override
	public void addTopic(String user, String topic) {		
		if(this.points instanceof Points){
			this.user.setNome(user);
			this.points.setUsuario(this.user);
			this.points.setTopic(topic);	
						
			if(this.points.getNome().equals("CREATION") || this.points.getNome().equals("PARTICIPATION") ){
				total+=points.getQuant();
				this.points.setQuant(total);
				
				if(total == 100 && points.getNome().equals("CREATION")){						
				   this.badge.setTopic("INVENTOR");	
				 }else{
					 this.badge.setTopic("PART OF THE COMMUNITY");	 
				 }				   
				   this.points.setBadge(badge);
				   this.points.setAchievement(badge);
				   this.points.setAchievement(points);
				   this.achievement.setAchievement(points);				
			  }
		}
		
		lista.add(this.achievement);
	}

	

	@Override
	public void addComment(String user, String topic, String comment) {
		this.user.setNome(user);
		this.achievement.setUsuario(this.user);
		this.achievement.setTopic(topic);
		this.achievement.setComentario(comment);
		
		if(achievement instanceof Points){
			   total+= ((Points) achievement).getQuant();	
		}
		
		this.lista.add(this.achievement);
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		this.user.setNome(user);
		this.user.setTopicUsuario(topicUser);
		this.achievement.setUsuario(this.user);
		this.achievement.setNome(topic);	
		
		if(achievement instanceof Points){
			   total+= ((Points) achievement).getQuant();	
		}
		
		this.lista.add(this.achievement);
	}

	@Override
	public void likeComment(String user, String topic, String comment,
			String commentUser) {
		this.user.setNome(user);
		this.user.setCommentUsuario(commentUser);
		this.achievement.setUsuario(this.user);
		this.achievement.setNome(topic);	
		
		if(achievement instanceof Points){
			   total+= ((Points) achievement).getQuant();	
		}
		this.lista.add(this.achievement);
	}

	public List<Achievement> getLista() {
		return lista;
	}

	public int getTotal() {
		return total;
	}	
	

}
