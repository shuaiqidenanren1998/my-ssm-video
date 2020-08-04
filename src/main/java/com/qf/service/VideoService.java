package com.qf.service;

import com.qf.pojo.Video;

import java.util.List;

public interface VideoService {

    public List<Video> findAllVideo();
    public void addVideo(Video video);
    public void delete (Integer id);
    public Video showOne(Integer id);
    public void updateVideo(Video video);
    public void deleteMany(Integer[] ids);
    public List<Video> selectVideoByQueryVo(Video video);
    public List<Video> conditionQuery(Video video);

}
