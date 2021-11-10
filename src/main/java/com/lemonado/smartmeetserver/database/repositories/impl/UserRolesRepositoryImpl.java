package com.lemonado.smartmeetserver.database.repositories.impl;

import com.lemonado.smartmeetserver.core.data.models.users.UserRoleModel;
import com.lemonado.smartmeetserver.core.repositories.UserRolesModelRepository;
import com.lemonado.smartmeetserver.database.data.mappers.UserRoleMapper;
import com.lemonado.smartmeetserver.database.data.modes.UserRoleEntity;
import com.lemonado.smartmeetserver.database.repositories.db.UserRoleDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRolesRepositoryImpl implements UserRolesModelRepository {

    @Autowired
    private UserRoleDatabaseRepository userRoleDatabaseRepository;

    @Override
    @Transactional
    public List<UserRoleModel> findByUserId(long userId) {
        List<UserRoleEntity> userRole = userRoleDatabaseRepository.findAllByUserId(userId);
        return userRole.stream().map(UserRoleMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public void saveAssign(long userId, long roleId) {
        var entity = UserRoleMapper.toEntity(userId, roleId);
        userRoleDatabaseRepository.save(entity);
    }

    @Override
    @Transactional
    public void removeAssign(long userId, long roleId) {
        var entity = UserRoleMapper.toEntity(userId, roleId);
        userRoleDatabaseRepository.delete(entity);
    }

    @Override
    public boolean isExists(long userId, long roleId) {
        var key = UserRoleMapper.toKey(userId, roleId);
        return userRoleDatabaseRepository.existsById(key);
    }

}
