package com.mydrive.user.service.entities;

import baseinterfaces.BasicDtoTable;
import com.mydrive.user.service.apis.dtos.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "UM_ROLE")
public class RoleEntity implements BasicDtoTable<RoleEntity, Role>, GrantedAuthority {


    @Id
    @Column(name = "UM_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "ACTIVE")
    private boolean active;

    @Override
    public void updateDto(Role role) {
        role.setId(getId());
        role.setActive(isActive());
        role.setRoleName(getAuthority());

    }

    @Override
    public void updateEntity(Role role) {
        setId(role.getId());
        setActive(role.isActive());
        setRoleName(role.getRoleName());
    }

    @Override
    public @Nullable String getAuthority() {
        return roleName;
    }
}
