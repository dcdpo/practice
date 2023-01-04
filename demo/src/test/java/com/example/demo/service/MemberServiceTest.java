package com.example.demo.service;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println(memberService.getTeacher(1));
    }

    @Test
    public void getStudentById() {
        System.out.println(memberService.getStudent(10));
    }

    @Test
    public void createMember() {
        Member member = new Member();
        member.setId("10");
        memberService.createMember(member);
    }

    @Test
    public void updateMember() {
        Member member = new Member();
        member.setName("哭阿");
        int id = 10;

//        memberService.updateMember(member, member);
    }

    @Test
    public void deleteProduct() {
        memberService.deleteMemberById(10);
    }
}