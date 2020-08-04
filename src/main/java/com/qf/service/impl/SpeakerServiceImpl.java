package com.qf.service.impl;

import com.qf.dao.SpeakerDao;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public List<Speaker> findAll() {
        return speakerDao.findAll();
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
    }

    @Override
    public void delete(Integer id) {
        speakerDao.delete(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }

    @Override
    public List<String> findSpeakerName() {
        return speakerDao.findSpeakerName();
    }

    @Override
    public List<Speaker> findAllSpeakers() {
        return speakerDao.findAllSpeakers();
    }

}
