package put.fc.sds.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import put.fc.sds.domain.IndividualOrder;
import put.fc.sds.domain.User;
import put.fc.sds.repository.IndividualOrderRepository;
import put.fc.sds.repository.UserRepository;

@RestController
public class IndividualOrderController {
	@Autowired
	IndividualOrderRepository individualOrderRepository;
	@Autowired
	UserRepository userRepository;
	@RequestMapping(value = "/individualOrder", method = RequestMethod.POST)
    public IndividualOrder individualOrder(@RequestBody @Valid IndividualOrder individualOrder,Principal principal) {
		String login = principal.getName();
		User user = userRepository.getByLogin(login);
		individualOrder.setUser(user);
		return individualOrderRepository.save(individualOrder);
    }
}
