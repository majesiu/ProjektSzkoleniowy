package put.fc.sds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import put.fc.sds.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		put.fc.sds.domain.User user = userRepository.getByLogin(username);
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
	}
}

