package com.lemonado.smartmeetserver.web.rest.models.mappings;

import com.lemonado.smartmeetserver.core.data.models.roles.RoleModel;
import com.lemonado.smartmeetserver.web.rest.models.dto.RoleDto;
import com.lemonado.smartmeetserver.web.rest.models.dto.builders.RoleDtoBuilder;

public class RoleMapper {

    public static RoleDto toDto(RoleModel model) {
        return new RoleDtoBuilder()
                .withId(model.id())
                .withName(model.name())
                .withDescription(model.description())
                .withCreateTimestamp(model.createTimestamp())
                .withUpdateTimestamp(model.updateTimestamp())
                .build();
    }

}
