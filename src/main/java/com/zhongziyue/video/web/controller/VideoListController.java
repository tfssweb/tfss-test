package com.zhongziyue.video.web.controller;

import com.zhongziyue.video.model.VideoList;
import com.zhongziyue.video.service.VideoService;
import com.zhongziyue.video.service.dto.CkPlayerDto;
import com.zhongziyue.video.service.dto.VideoPlayDto;
import com.zhongziyue.video.service.dto.VideosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VideoListController {
    private final VideoService videoService;

    @Autowired
    public VideoListController(VideoService videoService) {
        this.videoService = videoService;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:list";
    }

    @RequestMapping(value = "/list")
    public String Lists(Model model) {
        List<VideoList> videoLists = videoService.findAllVideoLists();
        model.addAttribute("videos_url", "/videos");
        model.addAttribute("lists", videoLists);
        System.out.println("videos_url: "+"/videos");
        System.out.println("lists: "+videoLists);
        return "lists";
    }

    @RequestMapping(value = "/videos")
    public String Videos(Model model, String lid, String path) {
        if (path == null) {
            path = "";
        }
        System.out.println(path);
        VideosDto videosDto = videoService.loadVideos(Integer.valueOf(lid), path);
//        model.addAttribute("directorys", videosDto.getDirectorys());
//        model.addAttribute("videos", videosDto.getVideos());
        model.addAttribute("videosDto", videosDto);
        model.addAttribute("videos_url", "/videos");
        model.addAttribute("lid", lid);
        model.addAttribute("path", path);
        return "videos";
    }

    @RequestMapping(value = "/ckplayer")
    public String viedo(Model model, VideoPlayDto videoPlayDto) {
        CkPlayerDto video = videoService.setCkPlayer(videoPlayDto);
//		video.setPath("/movies/东京喰种re/WMSUB&PCSUB Tokyo Ghoul re 01 GB 1080P.mp4");


        model.addAttribute("videoInfo", video);
//        model.addAttribute("videosetname", videoSetName);
        model.addAttribute("videoname", videoPlayDto.getName());
        return "ckplayer";
    }
}