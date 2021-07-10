package com.kyojs.hairshop.domain.designer;

import com.kyojs.hairshop.domain.BaseTimeEntity;
import com.kyojs.hairshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Designer extends BaseTimeEntity {

    @Id
    @Column(name="dg_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "us_id", nullable = false)
    private User user;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String photo;

    @Column(length = 3, nullable = false)
    private Integer career;

    @Column(length = 50, nullable = false)
    private String info;

    @Builder
    public Designer(User user, String name, String photo, Integer career, String info) {
        this.user = user;
        this.name = name;
        this.photo = photo;
        this.career = career;
        this.info = info;
    }

    public void update(String name, String photo, Integer career, String info) {
        this.name = name;
        this.photo = photo;
        this.career = career;
        this.info = info;
    }


}
