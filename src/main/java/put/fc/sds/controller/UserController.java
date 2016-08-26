package put.fc.sds.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import put.fc.sds.domain.User;
import put.fc.sds.repository.UserRepository;
@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userRepository.getByLoginAndPassword(user.getLogin(),user.getPassword());
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
    public User user(@RequestBody @Valid User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
    }
}
