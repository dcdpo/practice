package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember() {
        List<Member> memberList = memberRepository.findAll();

        return memberList;
    }

    public List<Member> getAllTeacher() {
        List<Member> member = memberRepository.findTeacherBySubject();

        return member;
    }

    public List<Member> getAllStudent() {
        List<Member> member = memberRepository.findStudentBySubjectIsNull();

        return member;
    }

    public Member getTeacher(String id) {
        Member member = memberRepository.findTeacherByMemberId(id);

        return member;
    }

    public Member getStudent(String id) {
        Member member = memberRepository.findStudentByMemberId(id);

        return member;
    }
}