package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("rest/all")
    public ResponseEntity<?> getMembers() {
        List<Member> memberList = memberService.getAllMember();
        String message = memberService.noContent();

        if (memberList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(memberList);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @GetMapping("/rest/all-teacher")
    public ResponseEntity<?> getAllTeacher() {
        List<Member> memberList = memberService.getAllTeacher();
        String message = memberService.noContent();

        if (memberList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(memberList);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @GetMapping("/rest/all-student")
    public ResponseEntity<?> getAllStudent() {
        List<Member> memberList = memberService.getAllStudent();
        String message = memberService.noContent();

        if (memberList.size() > 0) {
            return ResponseEntity.ok().body(memberList);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @GetMapping("/rest/teacher")
    public ResponseEntity<?> getTeacherById(@RequestParam("id") String id) {
        Member member = memberService.getTeacher(Integer.valueOf(id));
        String message = memberService.noContent();

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @GetMapping("/rest/student")
    public ResponseEntity<?> getStudentById(@RequestParam("id") Integer id) {
        Member member = memberService.getStudent(id);
        String message = memberService.noContent();

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMember(@RequestBody @Valid Member member) {
        memberService.createMember(member);

        return ResponseEntity.ok().body("新增成功");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Integer id,
                                          @RequestBody Member member) {

        Member memberData = memberRepository.findById(String.valueOf(id)).orElse(null);
        //檢查有沒有這筆資料
        if (memberData == null) {
            return ResponseEntity.notFound().header("沒有這筆資料").build();
        }
        //修改這筆資料
        memberService.updateMember(member, memberData);
        //檢查是否更新成功
        Member updateDate = memberRepository.findById(String.valueOf(id)).orElse(null);

        if (updateDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(memberData);
        }
        return ResponseEntity.accepted().body("資料沒更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        Member member = memberRepository.findById(String.valueOf(id)).orElse(null);

        if (member == null) {
            ResponseEntity.noContent().header("沒有符合的資料").build();
        }

        try {
            memberService.deleteMemberById(id);
        } catch (Exception e) {
            return ResponseEntity.ok().header("發生異常").build();

        }
        return ResponseEntity.ok().header("刪除成功").build();
    }
}