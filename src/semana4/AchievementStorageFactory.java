package semana4;

public class AchievementStorageFactory {
	
	private AchievementStorage achievementStorage;		
	
	public void setAchievementStorage(AchievementStorage a){		
		this.achievementStorage = MemoryAchievementStorage.getInstance(a) ;			
	}
	
	public AchievementStorage getInstance(){		
		return this.achievementStorage;
	}	
	
}
