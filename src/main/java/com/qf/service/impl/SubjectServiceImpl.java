package com.qf.service.impl;

import com.qf.dao.SubjectDao;
import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAllSub() {
        return subjectDao.findAllSub();
    }

    @Override
    public Subject selectSubject(Integer id) {
        return subjectDao.selectSubject(id);
    }
}
