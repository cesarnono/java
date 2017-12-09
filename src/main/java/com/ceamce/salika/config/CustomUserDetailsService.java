package com.ceamce.salika.config; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ceamce.salika.dao.UsuarioDAOImp;
import com.ceamce.salika.model.UsuarioVO;
import javax.servlet.jsp.PageContext;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioDAOImp usuarioDAO;

	@Override        
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UsuarioVO usuario = usuarioDAO.findByUsername(username);
		
		if (usuario != null) {
			authorities.add(new SimpleGrantedAuthority(usuario.getUsua_permiso()));
			User user = new User(usuario.getUsua_usuario(), usuario.getUsua_password(), authorities);
                        return user;
		} 
		else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
