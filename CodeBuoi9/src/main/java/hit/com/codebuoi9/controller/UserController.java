package hit.com.codebuoi9.controller;

import hit.com.codebuoi9.dto.UserDTO;
import hit.com.codebuoi9.enums.EnumRole;
import hit.com.codebuoi9.jwt.JwtUtils;
import hit.com.codebuoi9.model.Role;
import hit.com.codebuoi9.model.User;
import hit.com.codebuoi9.repo.RoleRepository;
import hit.com.codebuoi9.repo.UserRepository;
import hit.com.codebuoi9.request.LoginRequest;
import hit.com.codebuoi9.response.UserResponse;
import hit.com.codebuoi9.service.UserDetailImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.error(e.getMessage());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImp userDetailImp = (UserDetailImp) authentication.getPrincipal();

        try {
            String accessToken = jwtUtils.generateTokenByUsername(userDetailImp.getUsername());
            String refreshToken = jwtUtils.generateRefreshTokenByUsername(userDetailImp.getUsername());
            return ResponseEntity.ok(new UserResponse(
                    userDetailImp.getId(),
                    userDetailImp.getFullName(),
                    accessToken,
                    refreshToken,
                    userDetailImp.getAuthorities()
            ));
        } catch (Exception e) {
            return ResponseEntity.ok("Login failed : " + e.getMessage());
        }
    }

    @PostMapping("/create_new_user")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findRoleByRoleName(EnumRole.ROLE_USER);
        user.setRole(role);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/user/get_user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            return ResponseEntity.ok("User not found with id : " + id);
        }
        return ResponseEntity.ok(findUser.get());
    }


    @GetMapping("/admin/get_all_user")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
