package com.qf.service;

import com.qf.pojo.Speaker;

import java.util.List;

public interface SpeakerService {

    public List<Speaker> findAll();
    public void addSpeaker(Speaker speaker);
    public void delete(Integer id);
    public void updateSpeaker(Speaker speaker);
    public List<String> findSpeakerName();
    public List<Speaker> findAllSpeakers();

}
