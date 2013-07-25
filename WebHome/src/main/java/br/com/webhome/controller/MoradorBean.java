package br.com.webhome.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.webhome.entity.Morador;
import br.com.webhome.entity.to.MoradorTO;
import br.com.webhome.entity.to.UsuarioTO;
import br.com.webhome.service.MoradorService;

@ManagedBean(name = "moradorBean")
@ViewScoped
public class MoradorBean extends BaseBean {
	@ManagedProperty("#{moradorService}")
	private MoradorService service;
	private Morador morador;
	private MoradorTO moradorTO;
	private boolean editMode;

	
	public MoradorBean(){
		moradorTO = new MoradorTO(); //Cria novo usuário
		SecurityContext context = SecurityContextHolder.getContext();//Recebe o contexto do usuario que logou
		if(context instanceof SecurityContext){
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication){
				
				String login = ((User)authentication.getPrincipal()).getUsername();
				//moradorTO = service.getMorador(login); // pega os dados do morador pego login DELE
			}
		}
	}
	public MoradorTO getMorador(){
		return moradorTO;
	}
	
	public void setMorador(Morador morador){
		this.morador = morador;
	}
	
	public void criarPublicacao(){
		
	}
	public void save(){
		if(morador.getId() == null || morador.getId().intValue() == 0){
			morador = service.save(morador);
			addInfoMessage("Morador criado com sucesso");
		}
		else{
			service.update(morador);
		}
	}
}
