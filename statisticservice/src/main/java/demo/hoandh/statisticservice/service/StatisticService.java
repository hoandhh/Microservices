package demo.hoandh.statisticservice.service;

import demo.hoandh.statisticservice.entity.Statistic;
import demo.hoandh.statisticservice.model.StatisticDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.hoandh.statisticservice.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.List;


public interface StatisticService {
    void add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();
}

@Transactional
@Service
class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void add(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        statisticRepository.findAll().forEach((statistic) -> {
            statisticDTOs.add(modelMapper.map(statistic, StatisticDTO.class));
        });

        return statisticDTOs;
    }
}
