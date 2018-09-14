package semana4;

import java.util.ArrayList;
import java.util.List;

public class MemoryAchievementStorageMock implements AchievementStorage {
	
	private Usuario usuario;
	private Achievement achievement;
	private List<Achievement> lista;	
	
		
	public MemoryAchievementStorageMock(Achievement achievement, String nome) {
		this.achievement = achievement;
		lista = new ArrayList<>();
		usuario = this.achievement.getUsuario();
		this.achievement.setUsuario(usuario);		
		lista.add(this.achievement);
	}

	@Override
	public void addAchievement(String user, Achievement achievement) {	
		this.usuario.setNome(user);
		this.achievement.setAchievement(achievement);
		this.achievement.setUsuario(this.usuario);
		lista.add(achievement);
	}

	@Override
	public List<Achievement> getAchievements(String user) {	
		if(lista.isEmpty()){
			System.out.println("Não existe usuário na lista");
		}else{
			for(int i= 0; i < lista.size();i++){				
				if(lista.get(i).getUsuario().getNome().equals(user)){					
					return lista;
				}
			}
		}
		
		return null;
	}

	@Override
	public Achievement getAchievement(String user, String achievementName) {
		Achievement achievement = null;
		if(lista.isEmpty()){
			System.out.println("Não existe usuário e nem achievement na lista");
		}else{
			for(int i = 0; i < lista.size(); i++){				
				if(lista.get(i).getUsuario().getNome().equals(user) && 
						lista.get(i).getNome().equals(achievementName)){				
					achievement = lista.get(i);
					return achievement;
				}
			}
		}
		
		return null;
	}

}
