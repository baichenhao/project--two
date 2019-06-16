package com.hbsd.rjxy.lunwen.bch.dao;

import com.hbsd.rjxy.lunwen.entity.Student;
import com.hbsd.rjxy.lunwen.entity.StudentWithSubject;
import com.hbsd.rjxy.lunwen.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StuWithSubRepository extends JpaRepository<StudentWithSubject, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update tbl_student_subject sws  set " +
            "sws.a_state = CASE WHEN :#{#sws.state} IS NULL THEN sws.a_state ELSE :#{#sws.state} END," +
            "sws.timestamp = CASE WHEN :#{#sws.timestamp} IS NULL THEN sws.timestamp ELSE :#{#sws.timestamp} END " +
            "where sws.a_id = :#{#sws.id}",nativeQuery = true)
    @Transactional(readOnly = false)
    void updateSub(@Param("sws") StudentWithSubject studentWithSubject);

    @Transactional(readOnly = true)
    @Query(value = "select * " +
            "from tbl_student_subject " +
            "where student_s_id = :#{#stuId} and subject_sub_id = :#{#subId}",nativeQuery = true)
    StudentWithSubject findByStuIdAndSubId(@Param("stuId") String stuId, @Param("subId") Integer subId);

    @Transactional(readOnly = true)
    //@Query(value = "select * " +
    //        "from tbl_student_subject " +
    //        "where subject_sub_id = :#{#subId}",nativeQuery = true)
    List<StudentWithSubject> findBySubject(Subject subject);
}
