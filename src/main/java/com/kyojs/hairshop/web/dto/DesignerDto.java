package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DesignerDto {

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private User user;
        private String name;
        private String photo;
        private Integer career;
        private String info;

        public Response(Designer designer) {
            this.id = designer.getId();
            this.user = designer.getUser();
            this.name = designer.getName();
            this.photo = designer.getPhoto();
            this.career = designer.getCareer();
            this.info = designer.getInfo();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private User user;
        private String name;
        private String photo;
        private Integer career;
        private String info;

        @Builder
        public SaveRequest(User user, String name, String photo, Integer career, String info) {
            this.user = user;
            this.name = name;
            this.photo = photo;
            this.career = career;
            this.info = info;
        }

        public Designer toEntity() {
            return Designer.builder()
                    .user(user)
                    .name(name)
                    .photo(photo)
                    .career(career)
                    .info(info)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private String name;
        private String photo;
        private Integer career;
        private String info;

        @Builder
        public UpdateRequest(String name, String photo, Integer career, String info) {
            this.name = name;
            this.photo = photo;
            this.career = career;
            this.info = info;
        }
    }
}
