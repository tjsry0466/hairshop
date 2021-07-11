package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.ShopService;
import com.kyojs.hairshop.web.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ShopApiController {
    private final ShopService shopService;

    @PostMapping("/api/v1/shop")
    public Long save(@RequestBody ShopDto.SaveRequest requestDto){
        return shopService.save(requestDto);
    }

    @PostMapping("/api/v1/shop/{id}")
    public Long update(@PathVariable Long id, @RequestBody ShopDto.UpdateRequest requestDto){
        return shopService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/shop/{id}")
    public Long delete(@PathVariable Long id) {
        shopService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/shop/{id}")
    public ShopDto.Response findById (@PathVariable Long id) {
        return shopService.findById(id);
    }
}