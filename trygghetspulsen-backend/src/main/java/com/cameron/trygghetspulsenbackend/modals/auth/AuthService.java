package com.cameron.trygghetspulsenbackend.modals.auth;

import com.cameron.trygghetspulsenbackend.config.JwtService;
import com.cameron.trygghetspulsenbackend.modals.user.Role;
import com.cameron.trygghetspulsenbackend.modals.user.User;
import com.cameron.trygghetspulsenbackend.modals.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user, user.getFirstName(), user.getId());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow(); // add exception
        var jwtToken = jwtService.generateToken(user, user.getFirstName(), user.getId());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}


