package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.Teacher;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("rest/all")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> memberList = memberService.getAllMember();

        if (memberList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(memberList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/rest/all-teacher")
    public ResponseEntity<List<Member>> getAllTeacher() {
        List<Member> memberList = memberService.getAllTeacher();

        if (memberList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(memberList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/rest/all-student")
    public ResponseEntity<List<Member>> getAllStudent() {
        List<Member> memberList = memberService.getAllStudent();

        if (memberList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(memberList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/rest/teacher")
    public ResponseEntity<Member> getTeacherById(@RequestParam("id") String id) {
        Member member = memberService.getTeacher(id);

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/rest/student")
    public ResponseEntity<Member> getStudentById(@RequestParam("id") String id) {
        Member member = memberService.getStudent(id);

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/teachers")
    public ResponseEntity<Member> createTeacher(@RequestBody @Valid Teacher teacher){
        Member member = memberService.createTeacher(teacher);

        return ResponseEntity.status(HttpStatus.OK).body(member);
    }
}