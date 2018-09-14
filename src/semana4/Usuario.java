package semana4;

public class Usuario {
	
	private String nome;
	
	private String topicUsuario;
	
	private String commentUsuario;
	
	public Usuario(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTopicUsuario() {
		return topicUsuario;
	}

	public void setTopicUsuario(String topicUsuario) {
		this.topicUsuario = topicUsuario;
	}

	public String getCommentUsuario() {
		return commentUsuario;
	}

	public void setCommentUsuario(String commentUsuario) {
		this.commentUsuario = commentUsuario;
	}

}
