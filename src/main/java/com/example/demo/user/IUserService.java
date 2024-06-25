package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;

public interface IUserService {

   List<User> getUsers();
   User registerUser(RegistrationRequest request);
   Optional<User> findByEmail(String email);

   void saveUserVerificationToken(User theUser, String verificationToken);

   String validateToken(String token);

   VerificationToken generateNewVerificationToken(String oldToken);


//    User add(User user);

//    List<UserRecord> getAllUsers();

//    void delete(String email);

//    User getUser(String email);

//    User update(User user);
}
