package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.shop.Shop;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ShopDto {

    @Getter
    public static class Response {
        private Long id;
        private User user;
        private String name;
        private String email;
        private String info;
        private String address;
        private String tel;
        private String location;
        private String add_info;
        private String opening_time;
        private String closing_time;
        private String opening_day;

        public Response(Shop shop) {
            this.id = shop.getId();
            this.user = shop.getUser();
            this.name = shop.getName();
            this.email = shop.getEmail();
            this.info = shop.getInfo();
            this.address = shop.getAddress();
            this.tel = shop.getTel();
            this.location = shop.getLocation();
            this.add_info = shop.getAdd_info();
            this.opening_time = shop.getOpening_time();
            this.closing_time = shop.getClosing_time();
            this.opening_day = shop.getOpening_day();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ListResponse{
        private Long id;
        private String name;
        private String info;
        private String address;
        private String tel;
        private String add_info;
        private String opening_time;
        private String closing_time;

        public ListResponse(Shop shop) {
            this.id = shop.getId();
            this.name = shop.getName();
            this.info = shop.getInfo();
            this.address = shop.getAddress();
            this.tel = shop.getTel();
            this.add_info = shop.getAdd_info();
            this.opening_time = shop.getOpening_time();
            this.closing_time = shop.getClosing_time();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private User user;
        private String name;
        private String email;
        private String info;
        private String address;
        private String tel;
        private String location;
        private String add_info;
        private String opening_time;
        private String closing_time;
        private String opening_day;

        @Builder
        public SaveRequest(User user, String name, String email, String info, String address, String tel, String location, String add_info, String opening_time, String closing_time, String opening_day) {
            this.user = user;
            this.name = name;
            this.email = email;
            this.info = info;
            this.address = address;
            this.tel = tel;
            this.location = location;
            this.add_info = add_info;
            this.opening_time = opening_time;
            this.closing_time = closing_time;
            this.opening_day = opening_day;
        }

        public Shop toEntity() {
            return Shop.builder()
                    .user(user)
                    .name(name)
                    .email(email)
                    .info(info)
                    .address(address)
                    .tel(tel)
                    .location(location)
                    .add_info(add_info)
                    .opening_time(opening_time)
                    .closing_time(closing_time)
                    .opening_day(opening_day)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest {
        private String name;
        private String email;
        private String info;
        private String address;
        private String tel;
        private String location;
        private String add_info;
        private String opening_time;
        private String closing_time;
        private String opening_day;

        @Builder
        public UpdateRequest(String name, String email, String info, String address, String tel, String location, String add_info, String opening_time, String closing_time, String opening_day) {
            this.name = name;
            this.email = email;
            this.info = info;
            this.address = address;
            this.tel = tel;
            this.location = location;
            this.add_info = add_info;
            this.opening_time = opening_time;
            this.closing_time = closing_time;
            this.opening_day = opening_day;
        }
    }
}
