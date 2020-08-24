package com.team.web.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
interface StatisticsService{

    List<AvgRainVO> findPbRain();
}
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired StatisticsRepository statisticsRepository;


    @Override
    public List<AvgRainVO> findPbRain() {
        return statisticsRepository.rainProb();
    }
}
