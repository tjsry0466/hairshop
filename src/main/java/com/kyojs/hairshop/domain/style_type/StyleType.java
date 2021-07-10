package com.kyojs.hairshop.domain.style_type;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class StyleType extends BaseTimeEntity {

    @Id
    @Column(name="sp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Type type;
}
