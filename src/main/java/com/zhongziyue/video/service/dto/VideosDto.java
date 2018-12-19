package com.zhongziyue.video.service.dto;

import com.zhongziyue.video.model.Video;

import java.util.List;

public class VideosDto {
    private List<Video> directorys;
    private List<Video> videos;
    private String vPath;

    public VideosDto() {
    }

    public List<Video> getDirectorys() {
        return directorys;
    }

    public VideosDto setDirectorys(List<Video> directorys) {
        this.directorys = directorys;
        return this;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public VideosDto setVideos(List<Video> videos) {
        this.videos = videos;
        return this;
    }

    public String getvPath() {
        return vPath;
    }

    public VideosDto setvPath(String vPath) {
        this.vPath = vPath;
        return this;
    }
}