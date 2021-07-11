package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.shop.Shop;
import com.kyojs.hairshop.domain.shop.ShopRepository;
import com.kyojs.hairshop.web.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public Long save(ShopDto.SaveRequest requestDto) {
        return shopRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ShopDto.UpdateRequest requestDto){
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        shop.update(requestDto.getName(), requestDto.getEmail(), requestDto.getInfo(), requestDto.getAddress(), requestDto.getTel(), requestDto.getLocation(), requestDto.getAdd_info(), requestDto.getOpening_time(), requestDto.getClosing_time(), requestDto.getOpening_day());
        return id;
    }

    public ShopDto.Response findById(Long id) {
        Shop entity = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        return new ShopDto.Response(entity);
    }

    @Transactional
    public List<ShopDto.ListResponse> findAll() {
        return shopRepository.findAll().stream()
                .map(ShopDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        shopRepository.delete(shop);
    }

}
