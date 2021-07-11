package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.day_off.DayOff;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.shop.Shop;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DayOffDto {

    @Getter
    public static class Response{
        private Long id;
        private Designer designer;
        private Shop shop;
        private Integer optional;
        private Integer day_of_week;
        private String start_day;
        private String end_day;

        public Response(DayOff dayOff) {
            this.id = dayOff.getId();
            this.designer = dayOff.getDesigner();
            this.shop = dayOff.getShop();
            this.optional = dayOff.getOptional();
            this.day_of_week = dayOff.getDay_of_week();
            this.start_day = dayOff.getStart_day();
            this.end_day = dayOff.getEnd_day();
        }
    }

    @Getter
    public static class ListResponse{
        private Long id;
        private Designer designer;
        private Shop shop;
        private Integer optional;
        private Integer day_of_week;
        private String start_day;
        private String end_day;

        public ListResponse(DayOff dayOff) {
            this.id = dayOff.getId();
            this.designer = dayOff.getDesigner();
            this.shop = dayOff.getShop();
            this.optional = dayOff.getOptional();
            this.day_of_week = dayOff.getDay_of_week();
            this.start_day = dayOff.getStart_day();
            this.end_day = dayOff.getEnd_day();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private Designer designer;
        private Shop shop;
        private Integer optional;
        private Integer day_of_week;
        private String start_day;
        private String end_day;

        @Builder
        public SaveRequest(Designer designer, Shop shop, Integer optional, Integer day_of_week, String start_day, String end_day) {
            this.designer = designer;
            this.shop = shop;
            this.optional = optional;
            this.day_of_week = day_of_week;
            this.start_day = start_day;
            this.end_day = end_day;
        }

        public DayOff toEntity() {
            return DayOff.builder()
                    .designer(designer)
                    .shop(shop)
                    .optional(optional)
                    .day_of_week(day_of_week)
                    .start_day(start_day)
                    .end_day(end_day)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private Integer optional;
        private Integer day_of_week;
        private String start_day;
        private String end_day;

        @Builder

        public UpdateRequest(Integer optional, Integer day_of_week, String start_day, String end_day) {
            this.optional = optional;
            this.day_of_week = day_of_week;
            this.start_day = start_day;
            this.end_day = end_day;
        }
    }
}
