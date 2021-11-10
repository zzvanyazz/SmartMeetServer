package com.lemonado.smartmeetserver.database.repositories.impl;

import com.lemonado.smartmeetserver.core.data.models.users.UserModel;
import com.lemonado.smartmeetserver.core.repositories.UserModelRepository;
import com.lemonado.smartmeetserver.database.data.mappers.UserMapper;
import com.lemonado.smartmeetserver.database.data.modes.UserEntity;
import com.lemonado.smartmeetserver.database.repositories.db.UserDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImpl implements UserModelRepository {

    @Autowired
    private UserDatabaseRepository userDatabaseRepository;

    @Override
    public List<UserModel> getAll() {
        var allUsersIterable = userDatabaseRepository.findAll();
        return StreamSupport
                .stream(allUsersIterable.spliterator(), false)
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> findLive(String normalizedUsername) {
        Optional<UserEntity> userEntity = userDatabaseRepository.findAlive(normalizedUsername);
        return userEntity.map(UserMapper::toModel);
    }

    @Override
    public Optional<UserModel> findActive(String normalizedUsername) {
        Optional<UserEntity> userEntity = userDatabaseRepository.findActive(normalizedUsername);
        return userEntity.map(UserMapper::toModel);
    }

    @Override
    public Optional<UserModel> findActive(Long id) {
        Optional<UserEntity> userEntity = userDatabaseRepository.findActive(id);
        return userEntity.map(UserMapper::toModel);
    }

    @Override
    public Optional<UserModel> findByName(String normalizedUsername) {
        return userDatabaseRepository.findByNormalizedUsername(normalizedUsername).map(UserMapper::toModel);
    }

    @Override
    public boolean existsByName(String normalizedUsername) {
        return userDatabaseRepository.existsByNormalizedUsername(normalizedUsername);
    }

    @Override
    public boolean existsById(long id) {
        return userDatabaseRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userDatabaseRepository.existsByEmail(email);
    }


    @Override
    public Optional<UserModel> getUser(long userId) {
        return userDatabaseRepository.findById(userId).map(UserMapper::toModel);
    }

    @Override
    public Optional<UserModel> createUser(UserModel userModel) {
        var userEntity = UserMapper.toEntity(userModel);
        userEntity = userDatabaseRepository.save(userEntity);
        userModel = UserMapper.toModel(userEntity);
        return Optional.of(userModel);
    }
}
