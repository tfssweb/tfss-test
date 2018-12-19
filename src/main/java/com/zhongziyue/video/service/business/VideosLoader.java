package com.zhongziyue.video.service.business;

import com.zhongziyue.video.model.Video;
import com.zhongziyue.video.model.VideoList;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.stream.Collectors;

public class VideosLoader {
    private String rpath;
    private VideoList videoList;
    private String subPath;

    public VideosLoader(String rpath, VideoList videoList, String subPath) {
        this.rpath = rpath;
        this.videoList = videoList;
        this.subPath = subPath;
    }

    public List<Video> loadVideos() {
        File root = new File(rpath, videoList.getPath());
        root = new File(root, subPath);
        File[] files = root.listFiles(this::isVideo);
        for (File file : files) {
            List<File> fileList = Arrays.asList(files);
            return fileList.stream().map(Video::new).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Video> loadDirectorys() {
        File root = new File(rpath, videoList.getPath());
        root = new File(root, subPath);
        File[] files = root.listFiles(File::isDirectory);
        if (files != null) {
            List<File> fileList = Arrays.asList(files);
            return fileList.stream().map(File::getName).map(Video::new).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private boolean isVideo(File pathname) {
        if (pathname.isDirectory()) {
            return false;
        }

        Set<String> suffixSet = new HashSet<>();
        suffixSet.add("mp4");
        suffixSet.add("mkv");
        String fileName = pathname.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (suffixSet.contains(suffix)) {
            return true;
        }
        return false;
    }
}