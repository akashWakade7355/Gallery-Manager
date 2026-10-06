package com.project.gallery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Integer userId;

	    @Column(name = "username", length = 200, nullable = false)
	    private String username;

	    @Column(name = "email", length = 200, nullable = false)
	    private String email;

	    @Column(name = "hashed_password", length = 200, nullable = false)
	    private String hashedPassword;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;
	    

		public User(String username, String email, String hashedPassword, LocalDateTime createdAt) {
			super();
			this.username = username;
			this.email = email;
			this.hashedPassword = hashedPassword;
			this.createdAt = createdAt;
		}


		public User() {
			super();
		}


		public Integer getUserId() {
			return userId;
		}

		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getHashedPassword() {
			return hashedPassword;
		}


		public void setHashedPassword(String hashedPassword) {
			this.hashedPassword = hashedPassword;
		}


		public LocalDateTime getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}


		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", hashedPassword="
					+ hashedPassword + ", createdAt=" + createdAt + "]";
		}
	
}
