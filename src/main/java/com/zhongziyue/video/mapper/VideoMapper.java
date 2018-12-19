package com.zhongziyue.video.mapper;

import com.zhongziyue.video.model.VideoList;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface VideoMapper {
    @Insert("INSERT INTO video_list(name, path) VALUES(#{name}, #{path})")
    int insert(VideoList videoList);

    @Select("SELECT id, name, path FROM video_list")
    List<VideoList> selectAll();

    @Select("SELECT name, path FROM video_list WHERE id=#{id}")
    VideoList select(Integer id);

    @Update("UPDATE video_list SET name=#{name}, path=#{path} WHERE id=#{id}")
    int update(VideoList videoList);

    @Delete("DELETE FROM video_list WHERE id=#{id}")
    int delete(Integer id);
}