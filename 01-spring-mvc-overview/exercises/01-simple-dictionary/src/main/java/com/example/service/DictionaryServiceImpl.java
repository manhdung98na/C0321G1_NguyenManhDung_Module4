package com.example.service;

import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Override
    public String translate(String input) {
        String result = "Không tìm thấy kết quả phù hợp";
        try {
            URL url = new URL("https://vdict.com/" + input + ",1,0,0.html");
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
