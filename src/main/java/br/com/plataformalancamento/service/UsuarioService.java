package br.com.plataformalancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.repository.ClienteRepository;
import br.com.plataformalancamento.security.UsuarioAplicacaoSecurity;

public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClienteModel clienteModel = clienteRepository.findByEmail(username);
		if(clienteModel == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UsuarioAplicacaoSecurity(clienteModel.getCodigo(), clienteModel.getEmail(), clienteModel.getSenha(), clienteModel.getPerfilUsuarioEnumeration());
	}

}
