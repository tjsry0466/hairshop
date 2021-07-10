package com.kyojs.hairshop.domain.style;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.designer.Designer;
import com.kyojs.hairshop.domain.style_type.StyleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Style extends BaseTimeEntity {

    @Id
    @Column(name = "st_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dg_id", nullable = false)
    private Designer designer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sp_id", nullable = false)
    private StyleType styleType;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    @Column(length = 50, nullable = false)
    private String optional;

    @Column(length = 50, nullable = false)
    private String etc;

    @Builder
    public Style(Designer designer, StyleType styleType, Gender gender, String optional, String etc) {
        this.designer = designer;
        this.styleType = styleType;
        this.gender = gender;
        this.optional = optional;
        this.etc = etc;
    }
}
