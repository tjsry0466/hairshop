package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.UserService;
import com.kyojs.hairshop.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserDto.SaveRequest requestDto){
        return userService.save(requestDto);
    }

    @PostMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserDto.UpdateRequest requestDto){
        return userService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id) {
        userService.delete(id);
        return id;
    }
    
    @GetMapping("/api/v1/user/{id}")
    public UserDto.Response findById (@PathVariable Long id) {
        return userService.findById(id);
    }
}
