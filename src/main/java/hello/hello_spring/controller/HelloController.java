package hello.hello_spring.controller;

import hello.hello_spring.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Gildong");
        model.addAttribute("items", Arrays.asList("사과", "바나나", "포도"));
        model.addAttribute("isLoggedIn", true); // or false
        return "hello"; // resources/templates/hello.html 을 찾아감
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        
        model.addAttribute("user", new UserDTO()); // 빈 객체 넘겨줌
        return "register"; // register.html 열기
    }

    @PostMapping("/register")
    public String submitForm(UserDTO user) {
        System.out.println("아이디: " + user.getUserName());
        System.out.println("비밀번호: " + user.getPw());
        System.out.println("이메일: " + user.getEmail());

        // 여기에 회원가입 저장 로직 넣으면 됨 (DB 저장 등)

        return "redirect:/index"; // 완료 후 welcome 페이지로 이동
    }

}
