package br.com.webhome.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.webhome.entity.Morador;
import br.com.webhome.service.MoradorService;

@ManagedBean(name = "moradorBean")
@ViewScoped
public class MoradorBean extends BaseBean {
	@ManagedProperty("#{moradorService}")
	private MoradorService service;
	private Morador morador;
	private boolean editMode;
	
	public Morador getMorador(){
		if(morador == null){
			morador = new Morador();
		}
			return morador;
	}
	
	public void setMorador(Morador morador){
		this.morador = morador;
	}
	
	public void save(){
		if(morador.getId() == null || morador.getId().intValue() == 0){
			morador = service.save(morador);
			addInfoMessage("Morador criado com sucesso");
		}
		else{
		}
	}
}
