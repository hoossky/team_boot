package com.team.web.statistics;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsRepository statisticsRepository, StatisticsService statisticsService) {

        this.statisticsService = statisticsService;
    }

//    @GetMapping("/test")
//    public void aVoid () {
//        statisticsService.();
//    }
//
//    @GetMapping("/avg")
//    public void avg(){
//        System.out.println(statisticsService.avgRain());}

        @GetMapping("/pbRain")
    public Map<String, List<AvgRainVO>> rainProb(){
        Map<String, List<AvgRainVO>> result = new HashMap<>();
        result.put("pbRain", statisticsService.findPbRain());
        return result;
        }

}
