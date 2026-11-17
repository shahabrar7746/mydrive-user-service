package com.mydrive.user.service.apis.dtos;

import com.mydrive.user.service.apis.commons.dtos.ActivableEntity;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends ActivableEntity {

    private List<Role> roles;

    private String username;

    private String password;

    private LocalDateTime registeredOn;

    private String email;

    private boolean verified;

    private boolean active;

}
