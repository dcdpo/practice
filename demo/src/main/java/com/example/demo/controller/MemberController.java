package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController{

    @Autowired
    private MemberService memberService;

    @GetMapping("rest/all")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> memberList = memberService.getAllMember();
        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

    @GetMapping("/rest/all-teacher")
    public ResponseEntity<List<Member>> getAllTeacher() {
        List<Member> memberList = memberService.getAllTeacher();

        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

    @GetMapping("/rest/all-student")
    public ResponseEntity<List<Member>> getAllStudent() {
        List<Member> memberList = memberService.getAllStudent();

        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

//    @GetMapping("/rest/student")
//    public ResponseEntity<Member> getMemberById(@RequestParam("id") Integer productId) {
//        List<Member> member = memberList();
//
//        if (productId <= member.size()) {
//            return ResponseEntity.status(HttpStatus.OK).body(member.get(productId - 1));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}


