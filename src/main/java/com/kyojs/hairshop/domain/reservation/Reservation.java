package com.kyojs.hairshop.domain.reservation;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Reservation extends BaseTimeEntity {

    @Id
    @Column(name = "re_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "st_id")
    private Style style;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer status;
}
