package com.qf.service.impl;

import com.qf.dao.VideoDao;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> findAllVideo() {
        return videoDao.findAllVideo();
    }

    @Override
    public void addVideo(Video video) {
        videoDao.addVideo(video);
    }

    @Override
    public void delete(Integer id) {
        videoDao.delete(id);
    }

    @Override
    public Video showOne(Integer id) {
        return videoDao.showOne(id);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public void deleteMany(Integer[] ids) {
        videoDao.deleteMany(ids);
    }

    @Override
    public List<Video> selectVideoByQueryVo(Video video) {
        return videoDao.selectVideoByQueryVo(video);
    }

    @Override
    public List<Video> conditionQuery(Video video) {
        return videoDao.conditionQuery(video);
    }
}
