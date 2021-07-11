package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.day_off.DayOff;
import com.kyojs.hairshop.domain.day_off.DayOffRepository;
import com.kyojs.hairshop.web.dto.DayOffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DayOffService {
    private final DayOffRepository dayOffRepository;

    @Transactional
    public Long save(DayOffDto.SaveRequest requestDto){
        return dayOffRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, DayOffDto.UpdateRequest requestDto){
        DayOff dayOff = dayOffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        dayOff.update(requestDto.getOptional(), requestDto.getDay_of_week(), requestDto.getStart_day(), requestDto.getEnd_day());
        return id;
    }

    public DayOffDto.Response findById(Long id) {
        DayOff entity = dayOffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));

        return new DayOffDto.Response(entity);
    }

    @Transactional
    public List<DayOffDto.ListResponse> findAllDesc() {
        return dayOffRepository.findAll().stream()
                .map(DayOffDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        DayOff dayOff = dayOffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("햐해당 유저가 없습니다. id= " + id));

        dayOffRepository.delete(dayOff);
    }
}
