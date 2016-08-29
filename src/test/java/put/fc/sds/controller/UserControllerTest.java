package put.fc.sds.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    	user = new User("user", "password");
        given(this.userRepository.getByLogin("user"))
            .willReturn(user);
        given(this.encoder.encode("password")).willReturn("password");
    }
	@Test
	public void testLoginAnauthorized() throws Exception {
        this.mvc.perform(post("/login")
        		.content(asJsonString(user))
        		.contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isUnauthorized());
	}
	@Test
	@WithMockUser
	public void testLoginAuthorized() throws Exception {
		this.mvc.perform(post("/login")
				.content(asJsonString(user))
				.contentType(MediaType.APPLICATION_JSON)
        	.accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
	}
	@Test
	public void testUser() {
	}
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
}
