package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.reservation.Reservation;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReservationDto {

    @Getter
    public static class Reponse{
        private Long id;
        private User user;
        private Style style;
        private Integer price;
        private Integer status;


        public Reponse(Reservation reservation) {
            this.id = reservation.getId();
            this.user = reservation.getUser();
            this.style = reservation.getStyle();
            this.price = reservation.getPrice();
            this.status = reservation.getStatus();
        }
    }

    @Getter
    public static class ListResponse{
        private User user;
        private Style style;
        private Integer price;
        private Integer status;

        @Builder
        public ListResponse(Reservation reservation) {
            this.user = reservation.getUser();
            this.style = reservation.getStyle();
            this.price = reservation.getPrice();
            this.status = reservation.getStatus();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private User user;
        private Style style;
        private Integer price;
        private Integer status;

        @Builder
        public SaveRequest(User user, Style style, Integer price, Integer status) {
            this.user = user;
            this.style = style;
            this.price = price;
            this.status = status;
        }

        public Reservation toEntity() {
            return Reservation.builder()
                    .user(user)
                    .style(style)
                    .price(price)
                    .status(status)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private Integer status;

        @Builder
        public UpdateRequest(Integer status) {
            this.status = status;
        }
    }
}
