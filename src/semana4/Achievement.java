package semana4;

/*
 * Aautor: Antonio Halyon
 * Data:02/03/2018
 **/

public class Achievement {
	
	private String nome;	
	
	private Usuario usuario;
	
	private String topic;
	
	private String comentario;
	
	protected Achievement achievement;
	
	public Achievement(String nome) {		
		this.nome = nome;		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return achievement;
	}
	
}
