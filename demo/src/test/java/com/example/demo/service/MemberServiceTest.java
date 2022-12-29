package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void getMembers() {
        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList);
    }

    @Test
    public void getAllTeacher() {
        List<Member> member = memberRepository.findByJobTitleIsNotNull();
        System.out.println(member);
    }

    @Test
    public void getAllStudent() {
        List<Member> member = memberRepository.findBySubject();
        System.out.println(member);
    }

    @Test
    public void getTeacherById() {
        Member member = memberRepository.findByTeacherId("1");
        System.out.println(member);
    }

    @Test
    public void getStudentById() {
        Member member = memberRepository.findByStudentId("3");
        System.out.println(member);
    }
}
