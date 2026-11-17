package com.mydrive.user.service.apis.commons.dtos;

import base.Entity;
import com.mydrive.user.service.apis.commons.interfaces.ActiveEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ActivableEntity extends Entity implements ActiveEntity {
    private boolean active;
}
