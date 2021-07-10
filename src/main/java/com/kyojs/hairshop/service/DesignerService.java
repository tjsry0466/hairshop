package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.designer.DesignerRepository;
import com.kyojs.hairshop.web.dto.DesignerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DesignerService {
    private final DesignerRepository designerRepository;

    @Transactional
    public Long save(DesignerDto.SaveRequest requestDto){
        return designerRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, DesignerDto.UpdateRequest requestDto){
        Designer designer = designerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 디자이너가 없습니다 id = " + id));

        designer.update(requestDto.getName(), requestDto.getPhoto(), requestDto.getCareer(), requestDto.getInfo());
        return id;
    }

    public DesignerDto.Response findById(Long id){
        Designer entity = designerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 디자이너가 없습니다. id = " + id));

        return new DesignerDto.Response(entity);
    }

    @Transactional
    public List<DesignerDto.ListResponse> findAll() {
        return designerRepository.findAll().stream()
                .map(DesignerDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Designer designer = designerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("디자이너가 없습니다. id = " + id));

        designerRepository.delete(designer);
    }

}
