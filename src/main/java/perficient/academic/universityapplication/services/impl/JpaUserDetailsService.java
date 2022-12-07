package perficient.academic.universityapplication.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import perficient.academic.universityapplication.models.SecurityUser;
import perficient.academic.universityapplication.repositories.UserRepository;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService
{
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return userRepository.findUserByEmail(username)
				.map(SecurityUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
	}
}
