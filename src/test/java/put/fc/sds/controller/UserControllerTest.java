package put.fc.sds.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.BDDMockito.given;

import put.fc.sds.domain.User;
import put.fc.sds.repository.UserRepository;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	
	@Autowired
    private MockMvc mvc;
	
    @MockBean
    private UserRepository userRepository;
    @MockBean
    PasswordEncoder encoder;
    
    User user;
    
    @Before
    public void setup() {
    	user = new User("login", "password");
        given(this.userRepository.getByLogin("login"))
            .willReturn(user);
        given(this.encoder.encode("password")).willReturn("password");
    }
	@Test
	public void testLoginAnauthorized() throws Exception {
        this.mvc.perform(post("/login",user)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isUnauthorized());
	}

	@Test
	public void testUser() {
	}

}
