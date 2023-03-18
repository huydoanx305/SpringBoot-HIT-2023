package com.example.buoi2.controller;

import com.example.buoi2.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller //Đánh dấu class là component (để tạo bean) ở layer controller
public class TestController {

  @RequestMapping("/home") //định nghĩa các url, method(GET, POST, ...) và ánh xạ các request vào tới các phương thức xử lý request tương ứng
  public String index(Model model) {
//     truyền một biến xuống view
    model.addAttribute("string", "Hello World");

    Student student = new Student(1 , "A" , 10);
    Student student1 = new Student(2 , "B" , 20);

//     truyền object xuống view
//     model.addAttribute("bien", student.toString());
    model.addAttribute("student", student);

    List<Student> students = new LinkedList<>();
    students.add(student);
    students.add(student1);

    //truyền list xuống view
    model.addAttribute("students", students);

//    Sử dụng ModelAndView
//    ModelAndView view = new ModelAndView("index");
//    view.addObject("abc", "Hello Spring");
//    return view;
    return "index";
  }

//  @RequestParam để bắt các tham số trong request (VD: localhost:8080/about?search=2342&string=2342)
//   và gán với các biến tương ứng trong phương thức
  @RequestMapping(value = "/about", method = RequestMethod.GET)
  public String about(@RequestParam("search") String search, Model model) {
    model.addAttribute("search", search);
    return "about";
  }

//  ModelAttribute để bắt dữ liệu đối tượng (object) với các giá trị từ form dưới view truyền lên
//  ModelAttribute tìm các giá trị có name tương ứng với tên thuộc tính trong đối tượng và gán vào
  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public String test(@ModelAttribute Student student, Model model) {
    model.addAttribute("student", student);
    return "test";
  }

}
