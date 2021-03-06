package com.movieapi.security;

import com.movieapi.model.User;
import com.movieapi.security.jwt.TokenProvider;
import com.movieapi.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */
@RestController
@CrossOrigin
public class AuthController {

    private final UserService userService;

    private final TokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthController(PasswordEncoder passwordEncoder, UserService userService,
                          TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

        User user = new User();
        user.setUsername("admin");
        user.setPassword(this.passwordEncoder.encode("admin"));
        //this.userService.addUser(user);
    }

    @GetMapping("/authenticate")
    public void authenticate() {
        // we don't have to do anything here
        // this is just a secure endpoint and the JWTFilter
        // validates the token
        // this service is called at startup of the app to check
        // if the jwt token is still valid
    }

    @PostMapping("/login")
    public ResponseEntity<User> authorize(@Valid @RequestBody User loginUser,
                                          HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginUser.getUsername(), loginUser.getPassword());

        try {
            this.authenticationManager.authenticate(authenticationToken);
            String tokenString = tokenProvider.createToken(loginUser.getUsername());
            User user = new User();
            user.setJwtToken(tokenString);
            return new ResponseEntity<User>(user,HttpStatus.OK);

        }
        catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User signupUser) {
        if (this.userService.usernameExists(signupUser.getUsername())) {
            return "EXISTS";
        }

        signupUser.encodePassword(this.passwordEncoder);
        signupUser.setUserRole(2);
        this.userService.addUser(signupUser);
        return this.tokenProvider.createToken(signupUser.getUsername());
    }

    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/user/edit",method = RequestMethod.PUT)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        User existUser = userService.getUserById(user.getId());
        if (existUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            user.encodePassword(this.passwordEncoder);
            User persistUser = userService.editUser(user);
            return new ResponseEntity<User>(persistUser, HttpStatus.OK);
        }
    }
}
