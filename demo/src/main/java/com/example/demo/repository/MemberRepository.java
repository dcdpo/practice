package com.example.demo.repository;

import com.example.demo.controller.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByJobTitleIsNotNull();

    @Query(value= "select * from MEMBER m where m.subject=?1", nativeQuery = true)
    public Member findBySubject(String subject);

//    Member findByTitleAndId(String title, String id);
}
