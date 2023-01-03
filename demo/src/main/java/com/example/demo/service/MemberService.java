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
        List<Teacher> teacherList = memberRepository.findTeacherBySubject();
        List<Student> studentList = memberRepository.findStudentBySubjectIsNull();
        List<Member> memberList = new ArrayList<>();

        for (Teacher teacher : teacherList){
            memberList.add(teacher);
        }
        for (Student student : studentList){
            memberList.add(student);
        }

        return memberList;
    }

    public List<Member> getAllTeacher() {
        List<Teacher> teacherList = memberRepository.findTeacherBySubject();
        List<Member> memberList = new ArrayList<>();

        for (Teacher teacher : teacherList){
            memberList.add(teacher);
        }

        return memberList;
    }

    public List<Member> getAllStudent() {
        List<Student> studentList = memberRepository.findStudentBySubjectIsNull();
        List<Member> memberList = new ArrayList<>();

        for (Student student : studentList){
            memberList.add(student);
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