package testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import semana4.Achievement;
import semana4.AchievementStorage;
import semana4.MemoryAchievementStorage;
import semana4.MemoryAchievementStorageMock;
import semana4.Points;
import semana4.Usuario;

public class TestAchievement {

	private String userName;
	private Achievement achievement;
	private Achievement points;
	private AchievementStorage achievementStorage;	
	private static AchievementStorage mAchievementStorage;
	private List<Achievement> lista;
	private Usuario usuario;
	
	public TestAchievement(){		
		userName = "Halyson";
		this.usuario = new Usuario(userName);
		this.achievement = new Achievement("CREATION");
		this.achievement.setUsuario(usuario);
		
		this.achievementStorage = new MemoryAchievementStorageMock(this.achievement, 
				this.usuario.getNome());					
		this.mAchievementStorage = new MemoryAchievementStorage(this.achievementStorage);
		this.lista = this.achievementStorage.getAchievements(this.userName);
	}

	@Test
	public void testAddAchievement() {			
		this.mAchievementStorage.addAchievement(this.userName, this.achievement);
		assertEquals("CREATION", this.achievement.getNome());
		assertEquals(userName, lista.get(0).getUsuario().getNome());
	}
	
	@Test
	public void testAddAchievementPoints() {		
		this.points = new Points(achievement.getNome());
		this.mAchievementStorage.addAchievement(this.userName, this.points);
		assertEquals("CREATION", this.achievement.getNome());
		assertEquals("CREATION", this.points.getNome());
		assertEquals(userName, this.lista.get(0).getUsuario().getNome());			
	}	
	
	@Test
	public void testGetAchievements() {					
		assertEquals(this.achievement, lista.get(0));	
		assertEquals(userName, lista.get(0).getUsuario().getNome());
		assertEquals(achievement, lista.get(0));
	}
	
    @Test
	public void testGetAchievement() {			
		Achievement achient = this.mAchievementStorage.getAchievement(this.userName, 
				this.achievement.getNome());		
		assertEquals(achient.getNome(), "CREATION");		
		assertEquals(achient.getUsuario().getNome(), "Halyson");
		assertEquals(achient.equals(achievement), achievement.equals(achient));
	}

}
