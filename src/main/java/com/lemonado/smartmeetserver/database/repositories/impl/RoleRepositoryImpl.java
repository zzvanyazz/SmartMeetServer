package com.lemonado.smartmeetserver.database.repositories.impl;

import com.lemonado.smartmeetserver.core.data.models.roles.RoleModel;
import com.lemonado.smartmeetserver.core.repositories.RoleModelRepository;
import com.lemonado.smartmeetserver.database.data.mappers.RoleMapper;
import com.lemonado.smartmeetserver.database.repositories.db.RoleDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class RoleRepositoryImpl implements RoleModelRepository {

    @Autowired
    private RoleDatabaseRepository roleDatabaseRepository;

    @Override
    public Optional<Long> findId(String name) {
        return roleDatabaseRepository.findId(name);
    }

    @Override
    public Optional<RoleModel> findByName(String name) {
        return roleDatabaseRepository.findByName(name).map(RoleMapper::toModel);
    }

    @Override
    public Optional<RoleModel> findById(long id) {
        return roleDatabaseRepository.findById(id).map(RoleMapper::toModel);
    }

    @Override
    public List<RoleModel> getAll() {
        var allRolesIterable = roleDatabaseRepository.findAll();
        return StreamSupport.stream(allRolesIterable.spliterator(), false)
                .map(RoleMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExists(long id) {
        return roleDatabaseRepository.existsById(id);
    }
}
