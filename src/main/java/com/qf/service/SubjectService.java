package com.qf.service;

import com.qf.pojo.Subject;

import java.util.List;

public interface SubjectService {

    public List<Subject> findAllSub();
    public Subject selectSubject(Integer id);

}
