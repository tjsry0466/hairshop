package com.kyojs.hairshop.domain.user;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "us_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String passwd;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 10, nullable = false)
    private String birth;

    @Column(length = 10)
    private String level = "1";

    @Column(length = 5)
    private Integer status = 1;

    @Column(length = 30, nullable = false)
    private String tel;

    @Column(length = 255, nullable = false)
    private String address;

    @Builder
    public User(String username, String passwd, String email, String name, Gender gender, Role role, String birth, String tel, String address) {
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

    public void update(String passwd, String email, String name, Gender gender, String birth, String tel, String address) {
        this.passwd = passwd;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}