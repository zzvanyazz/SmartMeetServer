package com.lemonado.smartmeetserver.database.data.mappers;

import com.lemonado.smartmeetserver.core.data.models.registration.StartRegistrationModel;
import com.lemonado.smartmeetserver.core.data.models.registration.builders.StartRegistrationModelBuilder;
import com.lemonado.smartmeetserver.database.data.modes.RegistrationCodeEntity;

public class RegistrationCodeMapper {

    public static RegistrationCodeEntity toEntity(String email, String code, long roleId) {
        RegistrationCodeEntity registrationCodeEntity = new RegistrationCodeEntity();
        registrationCodeEntity.setRegistrationCode(code);
        registrationCodeEntity.setEmail(email);
        registrationCodeEntity.setRoleId(roleId);
        return registrationCodeEntity;
    }

    public static StartRegistrationModel toModel(RegistrationCodeEntity entity) {
        return new StartRegistrationModelBuilder()
                .withRegistrationCode(entity.getRegistrationCode())
                .withEmail(entity.getEmail())
                .withRoleId(entity.getRoleId())
                .build();
    }

}
