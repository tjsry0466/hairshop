package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.ReviewService;
import com.kyojs.hairshop.service.ShopService;
import com.kyojs.hairshop.web.dto.ReviewDto;
import com.kyojs.hairshop.web.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApiController {
    private final ReviewService reviewService;

    @PostMapping("/api/v1/review")
    public Long save(@RequestBody ReviewDto.SaveRequest requestDto){
        return reviewService.save(requestDto);
    }

    @PostMapping("/api/v1/review/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReviewDto.UpdateReqeust requestDto){
        return reviewService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/review/{id}")
    public Long delete(@PathVariable Long id) {
        reviewService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/review/{id}")
    public ReviewDto.Response findById (@PathVariable Long id) {
        return reviewService.findById(id);
    }
}
