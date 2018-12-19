package com.zhongziyue.video.service;

import com.zhongziyue.video.model.Video;
import com.zhongziyue.video.model.VideoList;
import com.zhongziyue.video.service.dto.CkPlayerDto;
import com.zhongziyue.video.service.dto.VideoPlayDto;
import com.zhongziyue.video.service.dto.VideosDto;

import java.util.List;

public interface VideoService {
    List<VideoList> findAllVideoLists();

    VideoList findVideoListById(Integer id);

    VideosDto loadVideos(Integer id, String path);

    CkPlayerDto setCkPlayer(VideoPlayDto videoPlayDto);
}