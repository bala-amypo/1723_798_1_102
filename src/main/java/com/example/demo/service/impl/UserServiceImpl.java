// package com.example.demo.service;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
    
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User register(User user) {
       
//         Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
//         if (existingUser.isPresent()) {
//             throw new RuntimeException("User with this email already exists");
//         }

        
//         if (user.getRole() == null || user.getRole().isBlank()) {
//             user.setRole("USER");
//         }

       
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
//     }
// }