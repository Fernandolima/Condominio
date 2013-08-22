package br.com.webhomebeta.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo.].[ASSEMBLEIA]")
public class Assembleia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATAS")
	private int idAtas;

	@Column(name = "ASSEMBLEIA")
	private String assembleia;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAssebleia;

	@Column(name = "DATA_ATAS")
	private Date dataAtas;

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}

	/**
	 * @return the assembleia
	 */
	public String getAssembleia() {
		return assembleia;
	}

	/**
	 * @return the usuarioAssebleia
	 */
	public Usuario getUsuarioAssebleia() {
		return usuarioAssebleia;
	}

	/**
	 * @return the dataAtas
	 */
	public Date getDataAtas() {
		return dataAtas;
	}

	/**
	 * @param idAtas the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @param assembleia the assembleia to set
	 */
	public void setAssembleia(String assembleia) {
		this.assembleia = assembleia;
	}

	/**
	 * @param usuarioAssebleia the usuarioAssebleia to set
	 */
	public void setUsuarioAssebleia(Usuario usuarioAssebleia) {
		this.usuarioAssebleia = usuarioAssebleia;
	}

	/**
	 * @param dataAtas the dataAtas to set
	 */
	public void setDataAtas(Date dataAtas) {
		this.dataAtas = dataAtas;
	}

}
