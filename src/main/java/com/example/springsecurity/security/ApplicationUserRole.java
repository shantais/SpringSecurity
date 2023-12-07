package com.example.springsecurity.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.springsecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE));

    private final Set<ApplicationUserPermission> permissios;

    ApplicationUserRole(Set<ApplicationUserPermission> permissios) {
        this.permissios = permissios;
    }

    public Set<ApplicationUserPermission> getPermissios() {
        return permissios;
    }
}
