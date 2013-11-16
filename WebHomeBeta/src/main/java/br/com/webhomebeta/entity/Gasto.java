package br.com.webhomebeta.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[GASTO]")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GASTO")
	private int idGasto;
	@Column(name = "GASTO")
	private BigDecimal gasto;
	@Column(name = "DATA")
	private Date data;
	
	
	
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}	
	
	public BigDecimal getGasto() {
		return gasto;
	}
	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
