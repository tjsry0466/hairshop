package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.StyleService;
import com.kyojs.hairshop.service.UserService;
import com.kyojs.hairshop.web.dto.StyleDto;
import com.kyojs.hairshop.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StyleApiController {
    private final StyleService styleService;

    @PostMapping("/api/v1/style")
    public Long save(@RequestBody StyleDto.SaveRequest requestDto){
        return styleService.save(requestDto);
    }

    @PostMapping("/api/v1/style/{id}")
    public Long update(@PathVariable Long id, @RequestBody StyleDto.UpdateRequest requestDto){
        return styleService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/style/{id}")
    public Long delete(@PathVariable Long id) {
        styleService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/style/{id}")
    public StyleDto.Response findById (@PathVariable Long id) {
        return styleService.findById(id);
    }
}
