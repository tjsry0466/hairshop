package com.kyojs.hairshop.domain.shop_designer;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.shop.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ShopDesigner extends BaseTimeEntity {

    @Id
    @Column(name = "sd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dg_id", nullable = false)
    private Designer designer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sh_id", nullable = false)
    private Shop shop;
}
