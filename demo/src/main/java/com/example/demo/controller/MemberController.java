package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

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

        if (!CollectionUtils.isEmpty(memberList)) {
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

        try {
            memberService.createMember(member);

            return ResponseEntity.ok().body("新增成功");
        } catch (EntityExistsException e) {
            return ResponseEntity.ok().body("Id重複");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Integer id, @RequestBody Member member) {

        try {
            memberService.updateMember(id, member);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().header("沒有這筆資料").build();
        }

        //檢查是否更新成功
        Member updateDate = memberRepository.findById(String.valueOf(id)).orElse(null);

        return ResponseEntity.status(HttpStatus.OK).body(updateDate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {

        try {
            memberService.deleteMemberById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok().header("發生異常").build();
        }
        return ResponseEntity.ok().header("刪除成功").build();
    }
}