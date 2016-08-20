package put.fc.sds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import put.fc.sds.domain.User;
import put.fc.sds.repository.UserRepository;
@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userRepository.getByLoginAndPassword(user.getLogin(),user.getPassword());
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User user(@PathVariable int id) {
        return userRepository.getById(id);
    }
}
