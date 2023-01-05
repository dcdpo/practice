package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Message;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

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
        member.setId("4");
        try {
            memberService.createMember(member);
            System.out.println(memberRepository.findById("11"));
        } catch (EntityExistsException e) {
            System.out.println(Message.createFail());
        }
    }

    @Test
    public void updateMember() {
        Member member = new Member();
        member.setName("哭阿");
        int id = 10;
        try {
            memberService.updateMember(id, member);
            System.out.println(memberRepository.findById("10"));
        } catch (EntityNotFoundException e) {
            System.out.println(Message.updateFail());
        }
    }

    @Test
    public void deleteMember() {
        try {
            memberService.deleteMemberById(10);
            System.out.println(memberRepository.findById("10"));
        } catch (EntityNotFoundException e) {
            System.out.println(Message.deleteFail());
        }
    }
}