package com.kyojs.hairshop.domain.day_off;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.shop.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class DayOff extends BaseTimeEntity {

    @Id
    @Column(name = "do_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dg_id")
    private Designer designer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sh_id")
    private Shop shop;

    @Column(length = 5, nullable = false)
    private Integer type;

    @Column(length = 20, nullable = false)
    private Integer day_of_week;

    @Column(length = 20, nullable = false)
    private String start_day;

    @Column(length = 20, nullable = false)
    private String end_day;
}
