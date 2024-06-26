package com.example.demo.registration.token;

import java.util.Calendar;
import java.util.Date;

import com.example.demo.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long token_id;
   private String token;
   private Date expirationTime;
   private static final int EXPIRATION_TIME = 10;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;
   public VerificationToken() {};

   public VerificationToken(String token, User user) {
      super();
      this.token = token;
      this.user = user;
      this.expirationTime = this.getTokenExpirationTime();
   }

   public VerificationToken(String token) {
      super();
      this.token = token;
      this.expirationTime = this.getTokenExpirationTime();
   }

   public Date getTokenExpirationTime() {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(new Date().getTime());
      calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
      return new Date(calendar.getTime().getTime());
   }

public Long getToken_id() {
	return token_id;
}

public void setToken_id(Long token_id) {
	this.token_id = token_id;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public Date getExpirationTime() {
	return expirationTime;
}

public void setExpirationTime(Date expirationTime) {
	this.expirationTime = expirationTime;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


   
}