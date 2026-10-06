package com.project.gallery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Album {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "album_id")
	    private Integer albumId;

	    @Column(name = "album_name", length = 300, nullable = false)
	    private String albumName;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

		public Album(String albumName, LocalDateTime createdAt, User user) {
			super();
			this.albumName = albumName;
			this.createdAt = createdAt;
			this.user = user;
		}

		public Album() {
			super();
		}

		public Integer getAlbumId() {
			return albumId;
		}

		public String getAlbumName() {
			return albumName;
		}

		public void setAlbumName(String albumName) {
			this.albumName = albumName;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Album [albumId=" + albumId + ", albumName=" + albumName + ", createdAt=" + createdAt + ", user="
					+ user + "]";
		}
		
}
