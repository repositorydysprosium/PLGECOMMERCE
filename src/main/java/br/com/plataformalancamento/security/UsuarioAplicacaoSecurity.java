package br.com.plataformalancamento.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.plataformalancamento.enumeration.TipoPerfilUsuarioEnumeration;

public class UsuarioAplicacaoSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String email;
	
	private String senha;
	
	private Collection<? extends GrantedAuthority> grantedAuthorityList;
	
	public UsuarioAplicacaoSecurity(Long codigo, String email, String senha, Set<TipoPerfilUsuarioEnumeration> tipoPerfilUsuarioEnumerationList) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.grantedAuthorityList = tipoPerfilUsuarioEnumerationList.stream().map( perfilResultado -> new SimpleGrantedAuthority(perfilResultado.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorityList;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorityList() {
		return grantedAuthorityList;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setGrantedAuthorityList(Collection<? extends GrantedAuthority> grantedAuthorityList) {
		this.grantedAuthorityList = grantedAuthorityList;
	}

}
