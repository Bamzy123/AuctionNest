package org.babi.Services;

import org.babi.Dtos.Request.LoginRequest;
import org.babi.Dtos.Request.RegisterRequest;
import org.babi.Dtos.Response.ApiResponse;
import org.babi.Enums.Role;
import org.babi.Exceptions.InvalidOperationException;
import org.babi.Exceptions.EmailAlreadyUseException;
import org.babi.Exceptions.InvalidUserCredentialsException;
import org.babi.Models.User;
import org.babi.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) throw new EmailAlreadyUseException("Email already in use");
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(Role.valueOf(req.getRole().toUpperCase()));
        userRepository.save(user);
        return new ApiResponse(true, "User registered successfully");
    }

    public ApiResponse login(LoginRequest req) {
        Optional<User> userOpt = userRepository.findByUsername(req.getUsernameOrEmail());
        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(req.getPassword())) {
            throw new InvalidUserCredentialsException("Invalid username or password");
        }
        User user = userOpt.get();
        if (user.isBanned()) throw new InvalidOperationException("User is banned");
        return new ApiResponse(true, "Login successful");
    }
}