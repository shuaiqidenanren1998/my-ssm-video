package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.*;
import com.qf.service.CourseService;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("findAllVideo")
    @ResponseBody
    public Map findAllVideo (Integer page, Integer limit) {

        PageHelper.startPage(page, limit);

        List<Video> videos = videoService.findAllVideo();

        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        Map<String, Object> map = new HashMap();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());

        System.out.println(map);

        return map;

    }

    @RequestMapping("addVideo")
    @ResponseBody
    public void addVideo (Video video) {
        videoService.addVideo(video);
    }

    @RequestMapping("delete")
    @ResponseBody
    public void delete (Integer id) {
        videoService.delete(id);
    }

    @RequestMapping("showOne")
    @ResponseBody
    public Video showOne (Integer id) {
        return videoService.showOne(id);
    }

    @RequestMapping("updateVideo")
    @ResponseBody
    public void updateVideo (Video video) {
        videoService.updateVideo(video);
    }

    @RequestMapping("deleteMany")
    @ResponseBody
    public void deleteMany (Integer[] ids) {
        videoService.deleteMany(ids);
    }

    @RequestMapping("search")
    @ResponseBody
    public BaseResponse search (Integer page, Integer limit, GetValue getValue) {

        PageHelper.startPage(page, limit);

        Video video = new Video();
        video.setTitle(getValue.getSearch());
        video.setSpeakerId(getValue.getSpeakerIddd());
        video.setCourseId(getValue.getCourseIddd());

        List<Video> videos = videoService.conditionQuery(video);

        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        baseResponse.setData(videos);
        baseResponse.setPage(page);//当前页
        baseResponse.setLimit(limit);//每页几条
        baseResponse.setCount(pageInfo.getTotal());//数据总数
        return baseResponse;

    }

    @RequestMapping("showVideo")
    public String showVideo(String videoId, String subjectName, Model model) {

        model.addAttribute("subjectName", subjectName);
        Video video = videoService.showOne(Integer.parseInt(videoId));

        System.out.println(video);

        model.addAttribute("video", video);
        Course course = courseService.selectCourseById(video.getCourseId());
        model.addAttribute(course);
        return "/before/section.jsp";
    }

}
