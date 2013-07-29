package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Morador;
import br.com.webhomebeta.to.MoradorTO;

public interface MoradorDAO {
	
    public MoradorTO save(Morador morador);
   // public Morador getMorador(int id);
    public MoradorTO getMorador(String login);
    public List<MoradorTO> getMoradores();
    public void remove(Morador morador);
    public void update(Morador morador);
   
    
    
}
