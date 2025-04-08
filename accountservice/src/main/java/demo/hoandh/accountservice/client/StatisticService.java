package demo.hoandh.accountservice.client;

import demo.hoandh.accountservice.model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", url = "http://localhost:9082")
public interface StatisticService {
    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO);
}

//@Component
//class StatisticServiceImpl implements StatisticService {
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void add(StatisticDTO statisticDTO) {
//        // fallback
//        logger.error("Statistic service is slow");
//    }
//}