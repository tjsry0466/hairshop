package com.kyojs.hairshop.web;

import com.kyojs.hairshop.service.DesignerService;
import com.kyojs.hairshop.web.dto.DesignerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DesignerApiController {
    private final DesignerService designerService;

    @PostMapping("/api/v1/designer")
    public Long save(@RequestBody DesignerDto.SaveRequest requestDto){
        return designerService.save(requestDto);
    }

    @PostMapping("/api/v1/designer/{id}")
    public Long update(@PathVariable Long id, @RequestBody DesignerDto.UpdateRequest requestDto){
        return designerService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/designer/{id}")
    public Long delete(@PathVariable Long id) {
        designerService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/designer/{id}")
    public DesignerDto.Response findById (@PathVariable Long id) {
        return designerService.findById(id);
    }

}
