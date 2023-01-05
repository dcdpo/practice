package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "select * from MEMBER m where m.subject IS NOT NULL", nativeQuery = true)
    List<Member> findTeacherBySubject();

    @Query(value = "select * from MEMBER m where m.subject IS NULL ", nativeQuery = true)
    List<Member> findStudentBySubjectIsNull();

    @Query(value = "select * from MEMBER m where m.subject IS NOT NULL and m.member_id = :id", nativeQuery = true)
    Member findTeacherByMemberId(@Param("id") String id);

    @Query(value = "select * from MEMBER m where m.subject IS NULL and m.member_id = :id", nativeQuery = true)
    Member findStudentByMemberId(@Param("id") String id);
}