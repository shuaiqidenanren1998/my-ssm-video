package com.qf.dao;

import com.qf.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao {

    public List<Video> findAllVideo();
    public void addVideo(Video video);
    public void delete (Integer id);
    public Video showOne(Integer id);
    public void updateVideo(Video video);
    public void deleteMany(Integer[] ids);
    public List<Video> selectVideoByQueryVo(Video video);
    public List<Video> conditionQuery(Video video);

}
