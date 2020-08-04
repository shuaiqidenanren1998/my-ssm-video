package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private Integer id;
    private String courseTitle;
    private String courseDesc;
    private Integer subjectId;

    private String subjectName;

    private List<Video> videoList;

}
