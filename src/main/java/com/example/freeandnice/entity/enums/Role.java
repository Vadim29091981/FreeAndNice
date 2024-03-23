package com.example.freeandnice.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_MODER,
    ROLE_USER;
    @Override
    public String getAuthority() {
        return name();
    }
}