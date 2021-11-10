package com.lemonado.smartmeetserver.database.data.mappers;

import com.lemonado.smartmeetserver.core.data.models.users.UserRoleModel;
import com.lemonado.smartmeetserver.database.data.modes.UserRoleEntity;
import com.lemonado.smartmeetserver.database.data.modes.UserRoleKey;

public class UserRoleMapper {


    public static UserRoleKey toKey(long userId, long roleId) {
        UserRoleKey userRoleKey = new UserRoleKey();
        userRoleKey.setUserId(userId);
        userRoleKey.setRoleId(roleId);
        return userRoleKey;
    }


    public static UserRoleEntity toEntity(long userId, long roleId) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(userId);
        userRoleEntity.setRoleId(roleId);
        return userRoleEntity;
    }

    public static UserRoleModel toModel(UserRoleEntity userRoleEntity) {
        return new UserRoleModel(userRoleEntity.getUserId(), userRoleEntity.getRoleId());
    }

    public static UserRoleEntity toEntity(UserRoleModel userRoleModel) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(userRoleModel.userId());
        userRoleEntity.setRoleId(userRoleModel.roleId());
        return userRoleEntity;
    }

}
