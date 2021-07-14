package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm() {
        return "/index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("txtSearch") String txtSearch, Model model) throws IOException {
        System.out.println("input " + txtSearch);
        String result = "Không tìm thấy kết quả phù hợp";

        URL url = new URL("https://vdict.com/" + txtSearch + ",1,0,0.html");
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        // close scanner
        scanner.close();

        // regex
        Pattern p = Pattern.compile("class=\"list1\"><li><b>(.*?)</b>");
        Matcher m = p.matcher(content);
        //tạo queue để lưu trữ, tránh trùng lặp tin tức
        while (m.find()) {
            result = m.group(1);
            break;
        }
        System.out.println("result " + result);
        model.addAttribute("txtSearch", txtSearch);
        model.addAttribute("result", result);
        return "/result";
    }


}
