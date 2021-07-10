package com.kyojs.hairshop.web.dto;


import com.kyojs.hairshop.domain.user.Gender;
import com.kyojs.hairshop.domain.user.Role;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UsersDto {

    @Getter
    public static class Response{
        private Long id;
        private String email;
        private String name;
        private Gender gender;
        private String birth;
        private Role role;
        private String level;
        private Integer status;
        private String tel;
        private String address;

        public Response(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.name = user.getName();
            this.gender = user.getGender();
            this.birth = user.getBirth();
            this.role = user.getRole();
            this.level = user.getLevel();
            this.status = user.getStatus();
            this.tel = user.getTel();
            this.address = user.getAddress();
        }
    }

    @Getter
    public static class ListResponse{

    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private String username;
        private String passwd;
        private String email;
        private String name;
        private Gender gender;
        private Role role;
        private String birth;
        private String tel;
        private String address;

        @Builder
        public SaveRequest(String username, String passwd, String email, String name, Gender gender, Role role, String birth, String tel, String address) {
            this.username = username;
            this.passwd = passwd;
            this.email = email;
            this.name = name;
            this.gender = gender;
            this.role = role;
            this.birth = birth;
            this.tel = tel;
            this.address = address;
        }

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .passwd(passwd)
                    .email(email)
                    .gender(gender)
                    .role(role)
                    .birth(birth)
                    .tel(tel)
                    .address(address)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private String passwd;
        private String email;
        private String name;
        private Gender gender;
        private String birth;
        private String tel;
        private String address;

        @Builder
        public UpdateRequest(String passwd, String email, String name, Gender gender, String birth, String tel, String address) {
            this.passwd = passwd;
            this.email = email;
            this.name = name;
            this.gender = gender;
            this.birth = birth;
            this.tel = tel;
            this.address = address;
        }
    }

}
