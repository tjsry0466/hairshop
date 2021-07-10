package com.kyojs.hairshop.domain.day_off;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.shop.Shop;
import lombok.Builder;
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

    @Builder
    public DayOff(Designer designer, Shop shop, Integer type, Integer day_of_week, String start_day, String end_day) {
        this.designer = designer;
        this.shop = shop;
        this.type = type;
        this.day_of_week = day_of_week;
        this.start_day = start_day;
        this.end_day = end_day;
    }
}
