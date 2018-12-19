package com.zhongziyue.video.service.impl;

import com.zhongziyue.video.mapper.VideoMapper;
import com.zhongziyue.video.model.Video;
import com.zhongziyue.video.model.VideoList;
import com.zhongziyue.video.service.VideoService;
import com.zhongziyue.video.service.business.VideosLoader;
import com.zhongziyue.video.service.dto.CkPlayerDto;
import com.zhongziyue.video.service.dto.VideoPlayDto;
import com.zhongziyue.video.service.dto.VideosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
    private final VideoMapper videoMapper;

    @Value("${videos.rpath}")
    private String rpath;

    @Value("${videos.vpath}")
    private String vpath;

    @Autowired
    public VideoServiceImpl(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    public List<VideoList> findAllVideoLists() {
        return videoMapper.selectAll();
    }

    @Override
    public VideoList findVideoListById(Integer id) {
        return videoMapper.select(id);
    }

    @Override
    public VideosDto loadVideos(Integer id, String path) {
        VideoList videoList = videoMapper.select(id);
        VideosLoader videosLoader = new  VideosLoader(rpath, videoList, path);
        VideosDto videosDto = new VideosDto();
        videosDto.setVideos(videosLoader.loadVideos())
                .setDirectorys(videosLoader.loadDirectorys())
                .setvPath(videoList.getPath());
        return videosDto;
    }

    @Override
    public CkPlayerDto setCkPlayer(VideoPlayDto videoPlayDto) {

        videoPlayDto.setPath(vpath + videoPlayDto.getPath());
        return new CkPlayerDto(videoPlayDto);
    }
}