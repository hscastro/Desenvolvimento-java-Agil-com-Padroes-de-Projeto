package semana4;

public class NullTratamento implements Tratamento {

	private Achievement achievement;		
	
	public NullTratamento(String nomeAchievement){
		this.achievement = new Achievement(nomeAchievement);		
	}
	
	@Override
	public Achievement getInstance() {		
   	    return this.achievement; 		  		
	 }

}
