package com.qf.dao;

import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDao {

    public List<Subject> findAllSub();
    public Subject selectSubject(Integer id);

}
