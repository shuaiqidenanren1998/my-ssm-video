package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.datatransfer.ClipboardOwner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("findAll")
    public Map findAll (Integer page, Integer limit) {

        PageHelper.startPage(page, limit);

        List<Speaker> speakers = speakerService.findAll();

        PageInfo<Speaker> pageInfo = new PageInfo<>(speakers);

        Map<String, Object> map = new HashMap();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());

        return map;

    }

    @RequestMapping("addSpeaker")
    public void addSpeaker (Speaker speaker) {
        System.out.println(speaker);
        speakerService.addSpeaker(speaker);
    }

    @RequestMapping("delete")
    public void delete (Integer id) {
        speakerService.delete(id);
    }

    @RequestMapping("updateSpeaker")
    public void updateSpeaker (Speaker speaker) {
        System.out.println(speaker);
        speakerService.updateSpeaker(speaker);
    }

    @RequestMapping("findSpeakerName")
    public void findSpeakerName () {
        speakerService.findSpeakerName();
    }

    @RequestMapping("findAllSpeakers")
    public List<Speaker> findAllSpeaker () {
        return speakerService.findAllSpeakers();
    }


}
