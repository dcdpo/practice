package com.example.demo.service;

import com.example.demo.entity.Member;
//import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember(){
        List<Member>memberList = (List<Member>) memberRepository.findAll();

        return memberList;
    }

    public List<Member> getAllTeacher() {
        Member member = memberRepository.findByJobTitleIsNotNull();
        List<Member> memberList = new ArrayList<>();
        memberList.add(member);

        return memberList;
    }

    public List<Member> getAllStudent(){
        String subject = "數學";
        Member member = memberRepository.findBySubject(subject);
        List<Member> memberList = new ArrayList<>();
        memberList.add(member);

        return memberList;
    }

    public Member getTeacher(String teacherId){
//        String title = "is not null";
//        Member member = memberRepository.findByTitleAndId(title, teacherId);

        return null;
    }

    public Member getStudent(String studentId){
        return null;
    }
}
