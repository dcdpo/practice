package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class MemberController {

      public static List<Member> memberList(){
            List<Member>memberList = new ArrayList<>();

            memberList.add(teacher1());
            memberList.add(teacher2());
            memberList.add(student1());
            memberList.add(student2());

            return memberList;
      }
      public static Teacher teacher1(){
            Teacher teacher =new Teacher();

            teacher.setId("1");
            teacher.setName("Billy");
            teacher.setGender("male");
            teacher.setSubject("數學");
            teacher.setJobTitle("教務主任");

            return teacher;
      }

      public static Teacher teacher2(){
            Teacher teacher =new Teacher();

            teacher.setId("2");
            teacher.setName("Heidi");
            teacher.setGender("female");
            teacher.setSubject("英文");
            teacher.setJobTitle("教師");

            return teacher;
      }

      public static Student student1(){
            Student student = new Student();

            student.setId("3");
            student.setName("Jacky");
            student.setGender("male");
            student.setClasses("301");
            student.setAdmissionYearMonth("201910");

            return student;
      }

      public static Student student2(){
            Student student = new Student();

            student.setId("4");
            student.setName("Lawrence");
            student.setGender("male");
            student.setClasses("801");
            student.setAdmissionYearMonth("201812");

            return student;
      }

      @GetMapping("/products")
      public ResponseEntity<List<Member>> getProducts(){
                  return ResponseEntity.status(HttpStatus.OK).body(memberList());
      }

      @GetMapping("/rest/all-{title}")
      public ResponseEntity<String> getMember(@PathVariable String title){
            Pattern pattern = Pattern.compile(title);
            Matcher matcher = pattern.matcher(memberList().toString());

            if (matcher.find()){
                  return ResponseEntity.status(HttpStatus.OK).body(matcher.group());
            }else{
                  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
      }
}
