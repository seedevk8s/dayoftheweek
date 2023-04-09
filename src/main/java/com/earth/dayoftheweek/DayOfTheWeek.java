package com.earth.dayoftheweek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class DayOfTheWeek {

    @RequestMapping("/dayofweek")
    public String dayweek(int year, int month, int day, Model model) {

        //2. 요일 계산
        char dayOfWeek = getDayOfWeek(year, month, day);

        //작업한 결과를 Model에 저장 (DS이 Model을 View로 전달함)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("dayOfWeek", dayOfWeek);

        return "dayOfWeek";         //dayOfWeek.html 뷰의 이름을 반환

    }

    private char getDayOfWeek(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();        //cal의 모든 필드를 초기화
        cal.set(year, month-1, day);		//날짜 setting, 월(mm)은 0부터 11이기 때문에 1을 빼줘야 함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		//요일 리턴. 1~7 반환, 1:일요일, 2:월요일

        return "일월화수목금토".charAt(dayOfWeek-1);           //1~7 => 0~6
    }
}
