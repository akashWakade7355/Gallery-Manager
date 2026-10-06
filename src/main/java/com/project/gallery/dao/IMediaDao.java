package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.Media;
import com.project.gallery.entity.MediaType;

public interface IMediaDao {

    void saveMedia(Media media);

    Media getMediaByMediaId(Integer mediaId);

    List<Media> getAllMedia();

    List<Media> getMediaByUserId(Integer userId);

    List<Media> getMediaByAlbumId(Integer albumId);

    List<Media> getMediaByMediaType(MediaType mediaType);

    void updateMedia(Media media);

    void deleteMedia(Integer mediaId);
}
