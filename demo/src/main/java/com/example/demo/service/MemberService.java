package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember() {
        List<Teacher> teacher = memberRepository.findTeacherBySubject();
        List<Student> student = memberRepository.findStudentBySubjectIsNull();
        List<Member> memberList = new ArrayList<>();

        for (int i = 0 ; i <= teacher.size()-1; i++){
            memberList.add(teacher.get(i));
        }
        for (int j = 0 ; j <= student.size()-1; j++){
            memberList.add(student.get(j));
        }

        return memberList;
    }

    public List<Member> getAllTeacher() {
        List<Teacher> teacher = memberRepository.findTeacherBySubject();
        List<Member> memberList = new ArrayList<>();

        for (int i = 0 ; i <= teacher.size()-1; i++){
            memberList.add(teacher.get(i));
        }

        return memberList;
    }

    public List<Member> getAllStudent() {
        List<Student> student = memberRepository.findStudentBySubjectIsNull();
        List<Member> memberList = new ArrayList<>();

        for (int i = 0 ; i <= student.size()-1; i++){
            memberList.add(student.get(i));
        }

        return memberList;
    }

    public Member getTeacher(String id) {
        Teacher member = memberRepository.findTeacherByMemberId(id);

        return member;
    }

    public Member getStudent(String id) {
        Student member = memberRepository.findStudentByMemberId(id);

        return member;
    }
}