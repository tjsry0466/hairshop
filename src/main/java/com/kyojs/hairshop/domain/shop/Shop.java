package com.kyojs.hairshop.domain.shop;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Shop extends BaseTimeEntity {

    @Id
    @Column(name = "sh_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id", nullable = false)
    private User user;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String info;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 30, nullable = false)
    private Integer tel;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(length = 5, nullable = false)
    private Integer level;

    @Column(length = 5, nullable = false)
    private Integer status;

    @Column(length = 255, nullable = false)
    private String add_info;

    @Column(length = 5, nullable = false)
    private String opening_time;

    @Column(length = 5, nullable = false)
    private String closing_time;

    @Column(length = 10, nullable = false)
    private String opening_day;
}
