package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterCommandTest {

    @Mock
    public UserService userService;

    @InjectMocks
    public RegisterCommand registerCommand;

    @Mock
    public HttpServletRequest request;

    @Mock
    HttpSession session;

    @Test
    public void executeShouldReturnJSPFileName() {

        String email = "someemail@gmail.com";
        String pass = "password";
        when(request.getAttribute(eq("email"))).thenReturn(email);
        when(request.getAttribute(eq("password"))).thenReturn(pass);

        when(request.getSession()).thenReturn(session);

        User user = User.builder().withEmail(email).withPassword(pass).withRole(Role.STUDENT).build();
        when(userService.register(email, pass)).thenReturn(Optional.of(user));

        String result = registerCommand.execute(request);
        assertEquals("home.jsp", result);


        verify(session).setAttribute(eq("currentUser"), eq(user));

    }
}