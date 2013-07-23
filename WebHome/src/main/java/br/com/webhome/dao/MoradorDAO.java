package br.com.webhome.dao;

import java.util.List;

import br.com.webhome.entity.Morador;

public interface MoradorDAO {
	
    public Morador save(Morador morador);
    public Morador getMorador(int id);
    public List<Morador> getMoradores();
    public void remove(Morador morador);
    public void update(Morador morador);
    
}
