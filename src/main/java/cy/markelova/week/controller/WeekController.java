package cy.markelova.week.controller;

import cy.markelova.week.entity.Day;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeekController {

    @GetMapping("/showDay")
    public String showDay(@RequestParam(value = "day") String day) {
        try {
            Day dayRus = Day.createFromEnglish(day);
            return String.format("Сегодня %s", dayRus.getRussianName());
        } catch (IllegalArgumentException ex) {
            return "Неопознанный день";
        }
    }
}