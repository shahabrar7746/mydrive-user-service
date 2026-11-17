package com.mydrive.user.service.apis.dtos;

import com.mydrive.user.service.apis.commons.dtos.ActivableEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends ActivableEntity {
    private String roleName;
}
