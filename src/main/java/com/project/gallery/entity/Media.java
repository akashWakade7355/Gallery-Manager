package com.project.gallery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Media {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "media_id")
	    private Integer mediaId;

	    @Column(name = "media_name", length = 200, nullable = false)
	    private String mediaName;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "media_type", nullable = false)
	    private MediaType mediaType;

	    @Column(name = "file_path", length = 500)
	    private String filePath;

	    @Column(name = "file_size")
	    private Long fileSize;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    // Many Media belong to one User
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    // Many Media belong to one Album
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "album_id", nullable = false)
	    private Album album;

		public Media(String mediaName, MediaType mediaType, String filePath, Long fileSize, LocalDateTime createdAt,
				User user, Album album) {
			super();
			this.mediaName = mediaName;
			this.mediaType = mediaType;
			this.filePath = filePath;
			this.fileSize = fileSize;
			this.createdAt = createdAt;
			this.user = user;
			this.album = album;
		}

		public Media() {
			super();
		}

		public Integer getMediaId() {
			return mediaId;
		}

		public String getMediaName() {
			return mediaName;
		}

		public void setMediaName(String mediaName) {
			this.mediaName = mediaName;
		}

		public MediaType getMediaType() {
			return mediaType;
		}

		public void setMediaType(MediaType mediaType) {
			this.mediaType = mediaType;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public Long getFileSize() {
			return fileSize;
		}

		public void setFileSize(Long fileSize) {
			this.fileSize = fileSize;
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

		public Album getAlbum() {
			return album;
		}

		public void setAlbum(Album album) {
			this.album = album;
		}

		@Override
		public String toString() {
			return "Media [mediaId=" + mediaId + ", mediaName=" + mediaName + ", mediaType=" + mediaType + ", filePath="
					+ filePath + ", fileSize=" + fileSize + ", createdAt=" + createdAt + ", user=" + user + ", album="
					+ album + "]";
		}
	    
	    
}
