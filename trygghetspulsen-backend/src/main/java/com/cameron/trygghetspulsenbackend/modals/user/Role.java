package com.cameron.trygghetspulsenbackend.modals.user;


import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

public enum Role {
    USER("GET_POST"),
    ADMIN("POST_GET_DELETE_PUT");

    private final String permissions;





    public List<GrantedAuthority> splitPermissions() {
        String[] permissionsArray = permissions.split("_");

        return Arrays.stream(permissionsArray)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    public List<GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + name());

        List<GrantedAuthority> permissions = new ArrayList<>();

        permissions.add(role);
        permissions.addAll(splitPermissions());

        return permissions;
    }

    public  GrantedAuthority getRole() {
        return new SimpleGrantedAuthority("ROLE_" + name());
    }





}
