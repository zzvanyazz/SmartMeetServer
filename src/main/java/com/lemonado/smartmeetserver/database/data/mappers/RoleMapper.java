package com.lemonado.smartmeetserver.database.data.mappers;

import com.lemonado.smartmeetserver.core.data.models.roles.RoleModel;
import com.lemonado.smartmeetserver.database.data.modes.RoleEntity;

public class RoleMapper {

    public static RoleModel toModel(RoleEntity roleEntity) {
        var roleModelBuilder = RoleModel.builder();
        roleModelBuilder.withId(roleEntity.getId());
        roleModelBuilder.withName(roleEntity.getName());
        roleModelBuilder.withDescription(roleEntity.getDescription());
        roleModelBuilder.withCreateTimestamp(roleEntity.getCreateTimestamp());
        roleModelBuilder.withUpdateTimestamp(roleEntity.getUpdateTimestamp());
        return roleModelBuilder.build();
    }

    public static RoleEntity toEntity(RoleModel roleModel) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleModel.id());
        roleEntity.setName(roleModel.name());
        roleEntity.setDescription(roleModel.description());
        roleEntity.setCreateTimestamp(roleModel.createTimestamp());
        roleEntity.setUpdateTimestamp(roleModel.updateTimestamp());
        return roleEntity;
    }

}
