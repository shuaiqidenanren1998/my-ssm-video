package com.qf.dao;

import com.qf.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerDao {

    public List<Speaker> findAll();
    public void addSpeaker(Speaker speaker);
    public void delete(Integer id);
    public void updateSpeaker(Speaker speaker);
    public List<String> findSpeakerName();
    public List<Speaker> findAllSpeakers();

}
