package com.kyojs.hairshop.domain.style_type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    Color("염색"),
    Perm("펌"),
    Cut("커트");

    private String name;
}
