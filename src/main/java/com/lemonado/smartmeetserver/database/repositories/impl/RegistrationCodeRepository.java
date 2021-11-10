package com.lemonado.smartmeetserver.database.repositories.impl;

import com.lemonado.smartmeetserver.core.data.models.registration.StartRegistrationModel;
import com.lemonado.smartmeetserver.core.repositories.RegistrationRepository;
import com.lemonado.smartmeetserver.database.data.mappers.RegistrationCodeMapper;
import com.lemonado.smartmeetserver.database.repositories.db.RegistrationCodesDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class RegistrationCodeRepository implements RegistrationRepository {

    @Autowired
    private RegistrationCodesDatabaseRepository repository;


    @Override
    public void save(String email, String code, long roleId) {
        var entity = RegistrationCodeMapper.toEntity(email, code, roleId);
        repository.save(entity);
    }

    @Override
    public Optional<StartRegistrationModel> getRegistrationModelByCode(String code) {
        return repository.getByRegistrationCode(code).map(RegistrationCodeMapper::toModel);
    }

    @Transactional
    @Override
    public void deleteByCode(String code) {
        repository.deleteByRegistrationCode(code);
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {
        repository.deleteAllByEmail(email);
    }


    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }


}
