package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.review.Review;
import com.kyojs.hairshop.domain.review.ReviewRepository;
import com.kyojs.hairshop.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long save(ReviewDto.SaveRequest requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReviewDto.UpdateReqeust requestDto){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        review.update(requestDto.getType(), requestDto.getTitle(), requestDto.getContent(), requestDto.getRating(), requestDto.getStatus(), requestDto.getTags(), requestDto.getThumbnail());
        return id;
    }

    public ReviewDto.Response findById(Long id) {
        Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        return new ReviewDto.Response(entity);
    }

    @Transactional
    public List<ReviewDto.ListResponse> findAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        reviewRepository.delete(review);
    }
}
