package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.style.StyleRepository;
import com.kyojs.hairshop.web.dto.StyleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StyleService {
    private final StyleRepository styleRepository;

    @Transactional
    public Long save(StyleDto.SaveRequest requestDto) {
        return styleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, StyleDto.UpdateRequest requestDto){
        Style style = styleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        style.update(requestDto.getStyleType(), requestDto.getGender(), requestDto.getOptional(), requestDto.getEtc());
        return id;
    }

    public StyleDto.Response findById(Long id) {
        Style entity = styleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        return new StyleDto.Response(entity);
    }

    @Transactional
    public List<StyleDto.ListResponse> findAll() {
        return styleRepository.findAll().stream()
                .map(StyleDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Style style = styleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        styleRepository.delete(style);
    }

}
