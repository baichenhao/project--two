package com.hbsd.rjxy.lunwen.bch.service;

import com.hbsd.rjxy.lunwen.bch.dao.StuWithSubRepository;
import com.hbsd.rjxy.lunwen.bch.dao.StuWithSubService;
import com.hbsd.rjxy.lunwen.entity.StudentWithSubject;
import com.hbsd.rjxy.lunwen.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuWithSubServiceImpl implements StuWithSubService {

    @Autowired
    private StuWithSubRepository stuWithSubRepository;

    @Override
    public void updateStuWithSub(StudentWithSubject studentWithSubject) {
        stuWithSubRepository.updateSub(studentWithSubject);
    }

    @Override
    public StudentWithSubject findByStuIdAndSubId(String stuId, Integer subId) {
        return stuWithSubRepository.findByStuIdAndSubId(stuId, subId);
    }

    @Override
    public List<StudentWithSubject> getBySubId(Subject subject) {
        List<StudentWithSubject> ls = stuWithSubRepository.findBySubject(subject);
        return ls;
    }
}
