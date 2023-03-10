package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.Message;
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

    @GetMapping("rest/all/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        Member member = memberService.getById(Integer.valueOf(id));
        String message = memberService.noContent();

        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
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

            return ResponseEntity.ok().body(Message.createSuccess());
        } catch (EntityExistsException e) {
            return ResponseEntity.ok().body(Message.createFail());
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public ResponseEntity<?> updateMember(@PathVariable Integer id, @RequestBody Member member) {

        try {
            memberService.updateMember(id, member);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok().body(Message.updateFail());
        }

        //????????????????????????
        Member updateDate = memberRepository.findById(String.valueOf(id)).orElse(null);

        if (updateDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(Message.updateSuccess());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(Message.updateFailed());
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<?> deleteMember(@PathVariable String id) {
        try {
            memberService.deleteMemberById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok().body(Message.deleteFail());
        }
        return ResponseEntity.ok().body(Message.deleteSuccess());
    }
}