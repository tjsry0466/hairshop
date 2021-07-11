package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.DayOffService;
import com.kyojs.hairshop.web.dto.DayOffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DayOffApiController {
    private final DayOffService dayOffService;

    @PostMapping("/api/v1/dayoff")
    public Long save(@RequestBody DayOffDto.SaveRequest requestDto){
        return dayOffService.save(requestDto);
    }

    @PostMapping("/api/v1/dayoff/{id}")
    public Long update(@PathVariable Long id, @RequestBody DayOffDto.UpdateRequest requestDto){
        return dayOffService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/dayoff/{id}")
    public Long delete(@PathVariable Long id) {
        dayOffService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/dayoff/{id}")
    public DayOffDto.Response findById (@PathVariable Long id) {
        return dayOffService.findById(id);
    }
}
