package com.kyojs.hairshop.web.dto;

import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.style.Gender;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.style_type.StyleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StyleDto {

    @Getter
    public static class Response{
        private Long id;
        private Designer designer;
        private StyleType styleType;
        private Gender gender;
        private String optional;
        private String etc;

        public Response(Style style) {
            this.id = style.getId();
            this.designer = style.getDesigner();
            this.styleType = style.getStyleType();
            this.gender = style.getGender();
            this.optional = style.getOptional();
            this.etc = style.getEtc();
        }
    }

    @Getter
    public static class ListResponse{
        private Designer designer;
        private StyleType styleType;
        private Gender gender;
        private String optional;

        @Builder
        public ListResponse(Designer designer, StyleType styleType, Gender gender, String optional) {
            this.designer = designer;
            this.styleType = styleType;
            this.gender = gender;
            this.optional = optional;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private Designer designer;
        private StyleType styleType;
        private Gender gender;
        private String optional;
        private String etc;

        @Builder
        public SaveRequest(Designer designer, StyleType styleType, Gender gender, String optional, String etc) {
            this.designer = designer;
            this.styleType = styleType;
            this.gender = gender;
            this.optional = optional;
            this.etc = etc;
        }

        public Style toEntity() {
            return Style.builder()
                    .designer(designer)
                    .styleType(styleType)
                    .gender(gender)
                    .optional(optional)
                    .etc(etc)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private StyleType styleType;
        private Gender gender;
        private String optional;
        private String etc;

        @Builder
        public UpdateRequest(StyleType styleType, Gender gender, String optional, String etc) {
            this.styleType = styleType;
            this.gender = gender;
            this.optional = optional;
            this.etc = etc;
        }
    }
}
