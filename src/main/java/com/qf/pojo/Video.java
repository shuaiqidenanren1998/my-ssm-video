package com.qf.pojo;

import lombok.Data;


@Data
public class Video {

    private Integer id;
    private String title;
    private String detail;
    private Integer time;
    private Integer speakerId;
    private Integer courseId;
    private String videoUrl;
    private String imageUrl;
    private Integer playNum;

    /*private String speaker_name;*/
    private Speaker speaker;
    private Course course;


}
