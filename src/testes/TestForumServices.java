package testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import semana4.Achievement;
import semana4.Badge;
import semana4.ForumService;
import semana4.ForumServiceGamificationProxy;
import semana4.ForumServiceGamificationProxyMock;
import semana4.NullTratamento;
import semana4.Points;
import semana4.Usuario;

public class TestForumServices {

	private String userName;
	private String nomeAchivievement;
	private Points points; 
	private Badge badge; 
	private Achievement achievement;
	private ForumServiceGamificationProxyMock proxyMock;
	private ForumService forumService;
	private List<Achievement> lista = null;		
		
	public TestForumServices(){
		this.userName = "Halyson";
		this.nomeAchivievement = "CREATION";
		this.achievement = new NullTratamento(this.nomeAchivievement).getInstance();
		
		this.points = new Points(this.achievement.getNome());
		this.badge = new Badge(this.achievement.getNome());	
	
	}

	
	@Test
	public void testAchievement() {
		assertEquals(achievement.getNome(), points.getAchievement().getNome());					
		assertEquals(achievement.getNome(), points.getNome());
		assertEquals(achievement.getNome(), badge.getAchievement().getNome());	
		assertEquals(achievement.getNome(), badge.getNome());
	}
	
	@Test
	public void testAddTopic() {		
		this.points.setQuant(100);		
		this.badge.setTopic("I CAN TALK");
		this.points.setTopic(badge.getTopic());
		this.points.setBadge(badge);	
		this.points.setAchievement(points);
		this.achievement.setAchievement(points);
		
		this.proxyMock = new ForumServiceGamificationProxyMock(this.points, userName);	
		this.forumService = new ForumServiceGamificationProxy(this.proxyMock);
		
		this.forumService.addTopic(userName, points.getAchievement().getTopic());		
	    this.lista = this.proxyMock.getLista();	 	    
	    
		assertEquals(achievement.getNome(), points.getNome());				
		assertEquals("I CAN TALK", this.lista.get(0).getAchievement().getTopic());		
		assertEquals("INVENTOR", this.badge.getAchievement().getTopic());		
	}	
	
	
	@Test
	public void testAddComment() {			
		points.setNome("PARTICIPATION");				
		points.setTopic("LET ME ADD");
		points.setComentario("COMMENT PARTICIPATION");
		points.setQuant(3);		
		points.setAchievement(points);
		
		this.proxyMock = new ForumServiceGamificationProxyMock(this.points, userName);	
		this.forumService = new ForumServiceGamificationProxy(this.proxyMock);
		
		this.forumService.addComment(points.getUsuario().getNome(), 
				points.getTopic(), points.getComentario());
		
		this.lista = this.proxyMock.getLista();
		
		assertEquals("Halyson", points.getAchievement().getUsuario().getNome());
		assertEquals("PARTICIPATION", points.getAchievement().getNome());	
		assertEquals(points.getQuant(), 0, 3);				
		assertEquals("LET ME ADD", points.getAchievement().getTopic());		
		assertEquals("COMMENT PARTICIPATION", points.getAchievement().getComentario());		
	}	
	
	@Test
	public void testAddTopicParticition() {	
		this.points.setNome("PARTICIPATION");
		this.points.setQuant(100);		
		this.badge.setTopic("I CAN TALK");
		this.points.setTopic(badge.getTopic());
		this.points.setBadge(badge);		
		this.achievement.setAchievement(points);
		
		this.proxyMock = new ForumServiceGamificationProxyMock(this.points, userName);	
		this.forumService = new ForumServiceGamificationProxy(this.proxyMock);
		
		this.forumService.addTopic(userName, points.getAchievement().getTopic());		
	    this.lista = this.proxyMock.getLista();	 	    
	    
		assertEquals(achievement.getAchievement().getNome(), points.getNome());				
		assertEquals("I CAN TALK", this.lista.get(0).getAchievement().getTopic());		
		assertEquals("PART OF THE COMMUNITY", badge.getTopic());		
	}
	
	
	@Test
	public void testLikeTopic() {
		this.proxyMock = new ForumServiceGamificationProxyMock(this.points, userName);	
		this.forumService = new ForumServiceGamificationProxy(this.proxyMock);
		
		this.forumService.likeTopic(points.getUsuario().getNome(), points.getTopic(), 
				points.getAchievement().getTopic());
		
		Usuario u1 = points.getUsuario();
		u1.setTopicUsuario("MY TOPIC FANTASTIC");
		points.setUsuario(u1);			
		points.setQuant(1);
		points.setAchievement(points);	
		
		assertEquals("Halyson", points.getAchievement().getUsuario().getNome());
		assertEquals(points.getQuant(), 0, 1);		
		assertEquals("MY TOPIC FANTASTIC", points.getAchievement().getUsuario().getTopicUsuario());		
	}
	
	@Test
	public void testLikeCommen() {
		this.proxyMock = new ForumServiceGamificationProxyMock(this.points, userName);	
		this.forumService = new ForumServiceGamificationProxy(this.proxyMock);
		
		this.forumService.likeComment(points.getUsuario().getNome(), points.getAchievement().getTopic(),
				points.getAchievement().getComentario(), 
				points.getAchievement().getUsuario().getCommentUsuario());
		
		points.setNome("CREATION");
		Usuario u2 = points.getUsuario();
		u2.setNome(userName);					
		points.setQuant(1);		
		this.badge.setTopic("LET ME ADD");
		this.points.setTopic(badge.getTopic());
		this.points.setBadge(badge);
		this.points.setComentario("MY TOPIC FANTASTIC");
		u2.setCommentUsuario("MY COMMENT FANTASTIC");
		points.setUsuario(u2);
		this.achievement.setAchievement(points);

		assertEquals("Halyson", u2.getNome());
		assertEquals(points.getQuant(), 0, 1);		
		assertEquals("LET ME ADD", points.getAchievement().getTopic());	
		assertEquals("MY TOPIC FANTASTIC", points.getAchievement().getComentario());
		assertEquals("MY COMMENT FANTASTIC", points.getAchievement().getUsuario().getCommentUsuario());
	}

}
