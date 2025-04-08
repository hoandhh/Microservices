package demo.hoandh.statisticservice.repository;

import demo.hoandh.statisticservice.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
