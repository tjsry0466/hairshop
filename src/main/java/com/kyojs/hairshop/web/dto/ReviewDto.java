package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.review.Review;
import com.kyojs.hairshop.domain.shop.Shop;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewDto {

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private User user;
        private Style style;
        private Shop shop;
        private Designer designer;
        private Integer type;
        private String content;
        private Float rating;
        private Integer status;
        private String tags;
        private String thumbnail;

        public Response(Review review) {
            this.id = review.getId();
            this.user = review.getUser();
            this.style = review.getStyle();
            this.shop = review.getShop();
            this.designer = review.getDesigner();
            this.type = review.getType();
            this.content = review.getContent();
            this.rating = review.getRating();
            this.status = review.getStatus();
            this.tags = review.getTags();
            this.thumbnail = review.getThumbnail();
        }
    }

    @Getter
    public static class ListResponse{
        private Long id;
        private User user;
        private Style style;
        private Shop shop;
        private Designer designer;
        private Integer type;
        private String content;
        private Float rating;
        private Integer status;
        private String tags;
        private String thumbnail;

        public ListResponse(Review review) {
            this.id = review.getId();
            this.user = review.getUser();
            this.style = review.getStyle();
            this.shop = review.getShop();
            this.designer = review.getDesigner();
            this.type = review.getType();
            this.content = review.getContent();
            this.rating = review.getRating();
            this.status = review.getStatus();
            this.tags = review.getTags();
            this.thumbnail = review.getThumbnail();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private User user;
        private Style style;
        private Shop shop;
        private Designer designer;
        private Integer type;
        private String title;
        private String content;
        private Float rating;
        private Integer status;
        private String tags;
        private String thumbnail;

        @Builder
        public SaveRequest(User user, Style style, Shop shop, Designer designer, Integer type, String title, String content, Float rating, Integer status, String tags, String thumbnail) {
            this.user = user;
            this.style = style;
            this.shop = shop;
            this.designer = designer;
            this.type = type;
            this.title = title;
            this.content = content;
            this.rating = rating;
            this.status = status;
            this.tags = tags;
            this.thumbnail = thumbnail;
        }

        public Review toEntity() {
            return Review.builder()
                    .user(user)
                    .style(style)
                    .shop(shop)
                    .designer(designer)
                    .type(type)
                    .title(title)
                    .content(content)
                    .rating(rating)
                    .status(status)
                    .tags(tags)
                    .thumbnail(thumbnail)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateReqeust{
        private Integer type;
        private String title;
        private String content;
        private Float rating;
        private Integer status;
        private String tags;
        private String thumbnail;

        @Builder
        public UpdateReqeust(Integer type, String title, String content, Float rating, Integer status, String tags, String thumbnail) {
            this.type = type;
            this.title = title;
            this.content = content;
            this.rating = rating;
            this.status = status;
            this.tags = tags;
            this.thumbnail = thumbnail;
        }

        public Review toEntity() {
            return Review.builder()
                    .type(type)
                    .title(title)
                    .content(content)
                    .rating(rating)
                    .status(status)
                    .tags(tags)
                    .thumbnail(thumbnail)
                    .build();
        }
    }
}
