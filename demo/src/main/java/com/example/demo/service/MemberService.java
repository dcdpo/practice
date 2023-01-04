package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public String noContent() {
        String message = "查無資料";

        return message;
    }

    public List<Member> getAllMember() {
        List<Member> memberList = memberRepository.findAll();

        return memberList;
    }

    public List<Member> getAllTeacher() {
        List<Member> memberList = memberRepository.findTeacherBySubject();

        return memberList;
    }

    public List<Member> getAllStudent() {
        List<Member> memberList = memberRepository.findStudentBySubjectIsNull();

        return memberList;
    }

    public Member getTeacher(Integer id) {
        Member member = memberRepository.findTeacherByMemberId(String.valueOf(id));

        return member;
    }

    public Member getStudent(Integer id) {
        Member member = memberRepository.findStudentByMemberId(String.valueOf(id));

        return member;
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void updateMember(Member member, Member memberData) {

        memberData.setName(member.getName());
        memberData.setGender(member.getGender());
        memberData.setSubject(member.getSubject());
        memberData.setJobTitle(member.getJobTitle());
        memberData.setClasses(member.getClasses());
        memberData.setAdmissionYearMonth(member.getAdmissionYearMonth());

        memberRepository.save(memberData);
    }

    public void deleteMemberById(Integer id) {
        memberRepository.deleteById(String.valueOf(id));
    }
}