package com.hbsd.rjxy.lunwen.bch.dao;

import com.hbsd.rjxy.lunwen.entity.StudentWithSubject;
import com.hbsd.rjxy.lunwen.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StuWithSubService {

    /**
     * 保存 StudentWithSubject 表
     * @param studentWithSubject
     */
    void updateStuWithSub(StudentWithSubject studentWithSubject);

    /**
     * 根据stuid 和 subid查找
     * @param stuId
     * @param subId
     * @return
     */
    StudentWithSubject findByStuIdAndSubId(String stuId, Integer subId);

    /**
     * 根据 subId 查找 stuwithsub 表
     * @param subject
     * @return
     */
    List<StudentWithSubject> getBySubId(Subject subject);
}
