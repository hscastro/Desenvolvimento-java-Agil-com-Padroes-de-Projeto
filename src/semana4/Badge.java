package semana4;

public class Badge extends Achievement {
	
	public Badge(String name) {
		super(name);		
	}

	@Override
	public void setAchievement(Achievement achievement) {		
		super.achievement = achievement;
	}

	@Override
	public Achievement getAchievement() {		
		return this;
	}
	
	
}
