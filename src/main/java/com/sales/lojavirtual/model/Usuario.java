package com.sales.lojavirtual.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "seq_usuario",sequenceName ="seq_usuario",initialValue = 1,allocationSize = 1 )
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_usuario")
	private Long id;
	private String login;
	private String senha;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtual;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_acessos",uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id","acesso_id"},
	name = "unique_acesso_user"),
	joinColumns = @JoinColumn(name="usuario_id",referencedColumnName = "id",table = "usuarios", unique = false,
	foreignKey =@ForeignKey(name="usuario_fk",value = ConstraintMode.CONSTRAINT) ),
	inverseJoinColumns = @JoinColumn(name="acesso_id",unique = false, referencedColumnName = "id",table = "acessos",
	foreignKey = @ForeignKey(name="acesso_fk",value = ConstraintMode.CONSTRAINT)))
	private List<Acesso> acessos;
	
	// Autoridades = sao os acesso garantidos
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.acessos;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}
	
	

}
