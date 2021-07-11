package com.kyojs.hairshop.domain.review;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.shop.Shop;
import com.kyojs.hairshop.domain.style.Style;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseTimeEntity {

    @Id
    @Column(name = "rv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "st_id")
    private Style style;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sh_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dg_id")
    private Designer designer;

    @Column(nullable = false)
    private Integer type;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private Float rating;

    @Column(nullable = false)
    private Integer status;

    @Column(length = 255, nullable = false)
    private String tags;

    @Column(length = 200, nullable = false)
    private String thumbnail;

    @Builder
    public Review(User user, Style style, Shop shop, Designer designer, Integer type, String title, String content, Float rating, Integer status, String tags, String thumbnail) {
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

    public void update( Integer type, String title, String content, Float rating, Integer status, String tags, String thumbnail){
        this.type = type;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.status = status;
        this.tags = tags;
        this.thumbnail = thumbnail;
    }
}
