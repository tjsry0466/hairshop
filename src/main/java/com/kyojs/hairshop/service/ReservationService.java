package com.kyojs.hairshop.service;

import com.kyojs.hairshop.domain.reservation.Reservation;
import com.kyojs.hairshop.domain.reservation.ReservationRepository;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.style.StyleRepository;
import com.kyojs.hairshop.web.dto.ReservationDto;
import com.kyojs.hairshop.web.dto.StyleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Transactional
    public Long save(ReservationDto.SaveRequest requestDto) {
        return reservationRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReservationDto.UpdateRequest requestDto){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        reservation.update(requestDto.getStatus());
        return id;
    }

    public ReservationDto.Reponse findById(Long id) {
        Reservation entity = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        return new ReservationDto.Reponse(entity);
    }

    @Transactional
    public List<ReservationDto.ListResponse> findAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 헤어샵이 없습니다. id = " + id));

        reservationRepository.delete(reservation);
    }
}
