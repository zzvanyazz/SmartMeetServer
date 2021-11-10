package com.lemonado.smartmeetserver.database.data.mappers;

import com.lemonado.smartmeetserver.core.data.models.users.UserModel;
import com.lemonado.smartmeetserver.core.data.models.users.builders.UserModelBuilder;
import com.lemonado.smartmeetserver.database.data.modes.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userModel.id());
        userEntity.setUsername(userModel.username());
        userEntity.setPasswordHash(userModel.passwordHash());
        userEntity.setEmail(userModel.email());
        userEntity.setDeleteTimestamp(userModel.deleteTimestamp());
        userEntity.setValidTokenTimestamp(userModel.validTokenTimestamp());
        return userEntity;
    }

    public static UserModel toModel(UserEntity userEntity) {
        var userModelBuilder = new UserModelBuilder();
        userModelBuilder.withId(userEntity.getId());
        userModelBuilder.withUsername(userEntity.getUsername());
        userModelBuilder.withPasswordHash(userEntity.getPasswordHash());
        userModelBuilder.withEmail(userEntity.getEmail());
        userModelBuilder.withDeleteTimestamp(userEntity.getDeleteTimestamp());
        userModelBuilder.withValidTokenTimestamp(userEntity.getValidTokenTimestamp());
        return userModelBuilder.build();
    }

}
