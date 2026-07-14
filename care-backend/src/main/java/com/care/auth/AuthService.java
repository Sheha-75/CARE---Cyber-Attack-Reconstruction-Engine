package com.care.auth;

import com.care.auth.dto.LoginRequest;
import com.care.auth.dto.LoginResponse;
import com.care.auth.dto.RegisterRequest;
import com.care.role.Role;
import com.care.role.RoleRepository;
import com.care.role.RoleType;
import com.care.security.jwt.JwtService;
import com.care.user.User;
import com.care.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {

        // Check whether the email is already registered
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered.");
        }

        // Get the default INVESTIGATOR role
        Role investigatorRole = roleRepository
                .findByName(RoleType.INVESTIGATOR)
                .orElseThrow(() ->
                        new RuntimeException("Default role not found."));

        // Create a new user
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(investigatorRole)
                .build();

        userRepository.save(user);

        return "User registered successfully.";
    }

    public LoginResponse login(LoginRequest request) {

        // Find user by email
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password."));

        // Verify password
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password.");
        }

        // Generate JWT
        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}