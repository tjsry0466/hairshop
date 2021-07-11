package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.ReservationService;
import com.kyojs.hairshop.service.ShopService;
import com.kyojs.hairshop.web.dto.ReservationDto;
import com.kyojs.hairshop.web.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReservationApiController {
    private final ReservationService reservationService;

    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationDto.SaveRequest requestDto){
        return reservationService.save(requestDto);
    }

    @PostMapping("/api/v1/reservation/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReservationDto.UpdateRequest requestDto){
        return reservationService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/reservation/{id}")
    public Long delete(@PathVariable Long id) {
        reservationService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/reservation/{id}")
    public ReservationDto.Response findById (@PathVariable Long id) {
        return reservationService.findById(id);
    }
}
