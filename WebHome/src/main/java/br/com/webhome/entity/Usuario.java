package br.com.webhome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dbo.USER")
public class Usuario implements Serializable{
	@Column(name="NOME")
	String nome;
	String a;
	
}
