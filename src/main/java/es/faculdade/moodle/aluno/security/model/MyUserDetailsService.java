package es.faculdade.moodle.aluno.security.model;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	private Usuario usuario;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User(usuario.getLogin(),usuario.getSenha(),new ArrayList<>());
	}

}
