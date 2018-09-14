package semana4;

import java.util.List;

public class MemoryAchievementStorage implements AchievementStorage {
	
    private static AchievementStorage mAchievementStorage;     
   
	public MemoryAchievementStorage(AchievementStorage mAchievementStorage) {
	    this.mAchievementStorage = mAchievementStorage;		      	
	}	

	public static AchievementStorage getInstance(AchievementStorage m){
		mAchievementStorage = new MemoryAchievementStorage(m);
		return mAchievementStorage;
	}

	public void addAchievement(String user, Achievement a) {
		this.mAchievementStorage.addAchievement(user, a);
	}

	public List<Achievement> getAchievements(String user) {
		return this.mAchievementStorage.getAchievements(user);
	}

	public Achievement getAchievement(String user, String achievementName) {
		return this.mAchievementStorage.getAchievement(user, achievementName);
	}
	
}
