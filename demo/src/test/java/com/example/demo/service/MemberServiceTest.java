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
    private MemberService memberService;

    @Test
    public void getMembers() {
        System.out.println(memberService.getAllMember());
    }

    @Test
    public void getAllTeacher() {
        System.out.println(memberService.getAllTeacher());
    }

    @Test
    public void getAllStudent() {
        System.out.println(memberService.getAllStudent());
    }

    @Test
    public void getTeacherById() {
        System.out.println(memberService.getTeacher("1"));
    }

    @Test
    public void getStudentById() {
        System.out.println(memberService.getStudent("3"));
    }
}
