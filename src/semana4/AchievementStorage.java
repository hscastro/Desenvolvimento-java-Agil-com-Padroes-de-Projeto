package semana4;

import java.util.List;

public interface AchievementStorage {
	public abstract void addAchievement(String user, Achievement a);
	public abstract List<Achievement> getAchievements(String user);
	public abstract Achievement getAchievement(String user, String achievementName);
}
