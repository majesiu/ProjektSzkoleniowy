package put.fc.sds.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import put.fc.sds.domain.User;
import put.fc.sds.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		return new UserRepositoryUserDetails(user);

//		put.fc.sds.domain.User user = userRepository.getByLogin(username);
//		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
//				AuthorityUtils.createAuthorityList("USER"));
	}

	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private UserRepositoryUserDetails(User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getUsername() {
			return getLogin();
		}

		private static final long serialVersionUID = 5639683223516504866L;

	}

}
