package com.lemonado.smartmeetserver.database.repositories.db;

import com.lemonado.smartmeetserver.database.data.modes.UserRoleEntity;
import com.lemonado.smartmeetserver.database.data.modes.UserRoleKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDatabaseRepository extends CrudRepository<UserRoleEntity, UserRoleKey> {
    List<UserRoleEntity> findAllByUserId(Long userName);

}
