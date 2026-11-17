package com.mydrive.user.service.entities;

import baseinterfaces.BasicDtoTable;
import com.mydrive.user.service.apis.dtos.Role;
import com.mydrive.user.service.apis.dtos.User;
import converters.DtoConverterUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "UM_USER")
public class UserEntity implements UserDetails, BasicDtoTable<UserEntity, User> {

    @Id
    @Column(name = "UM_USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "VERIFIED")
    private boolean verified;

    @Column(name = "REGISTERED_ON")
    @CreationTimestamp
    private LocalDateTime registeredOn;

    @Column(name = "ACTIVE")
    private boolean active;

    @OneToMany
    private List<RoleEntity> roleEntityList;

    @Override
    public void updateDto(User user) {
        user.setId(getId());
        user.setRoles(
                getRoleEntityList()
                        .stream()
                        .map(re -> DtoConverterUtils.convertToDto(re, Role.class))
                        .toList()
        );
        user.setEmail(getEmail());
        user.setActive(isActive());
        user.setPassword(getPassword());
        user.setPassword(getPassword());
        user.setUsername(getUsername());
        user.setRegisteredOn(getRegisteredOn());
    }

    @Override
    public void updateEntity(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setActive(user.isActive());
        setVerified(user.isVerified());
        setPassword(user.getPassword());
        setEmail(getEmail());
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !verified;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleEntityList;
    }
}
