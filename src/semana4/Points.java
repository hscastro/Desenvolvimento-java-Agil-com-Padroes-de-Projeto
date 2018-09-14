package semana4;

public class Points extends Achievement {
	
	private int quant;
	
	private Badge badge;
			
	public Points(String nome) {
		super(nome);			
	}	

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	@Override
	public void setAchievement(Achievement achievement) {		
		super.achievement = achievement;
	}

	@Override
	public Achievement getAchievement() {		
		return this;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

}
