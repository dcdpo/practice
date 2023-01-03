package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query(value = "select * from MEMBER m where m.subject IS NOT NULL", nativeQuery = true)
    List<Teacher> findTeacherBySubject();

    @Query(value = "select * from MEMBER m where m.subject IS NULL ", nativeQuery = true)
    List<Student> findStudentBySubjectIsNull();

    @Query(value = "select * from MEMBER m where m.subject IS NOT NULL and m.member_id = :id", nativeQuery = true)
    Teacher findTeacherByMemberId(@Param("id") String id);

    @Query(value = "select * from MEMBER m where m.subject IS NULL and m.member_id = :id", nativeQuery = true)
    Student findStudentByMemberId(@Param("id") String id);
}