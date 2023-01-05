package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

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
        String id = member.getId();
        memberRepository.findById(id).ifPresentOrElse((memberData) -> {
            throw new EntityExistsException();
        }, () -> memberRepository.save(member));
    }

    public void updateMember(Integer id, Member member) {
        memberRepository.findById(String.valueOf(id)).ifPresentOrElse((memberData) -> {
            memberData.setName(member.getName());
            memberData.setGender(member.getGender());
            memberData.setSubject(member.getSubject());
            memberData.setJobTitle(member.getJobTitle());
            memberData.setClasses(member.getClasses());
            memberData.setAdmissionYearMonth(member.getAdmissionYearMonth());

            memberRepository.save(memberData);
        }, () -> {
            throw new EntityNotFoundException();
        });
    }

    public void deleteMemberById(Integer id) {
        memberRepository.findById(String.valueOf(id)).ifPresentOrElse((member) -> {
            memberRepository.delete(member);
        }, () -> {
            throw new EntityNotFoundException();
        });
    }
}