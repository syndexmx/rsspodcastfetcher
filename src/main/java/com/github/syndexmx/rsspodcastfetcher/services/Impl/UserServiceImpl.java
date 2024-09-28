package com.github.syndexmx.rsspodcastfetcher.services.Impl;

import com.github.syndexmx.rsspodcastfetcher.repositories.UserRepository;
import com.github.syndexmx.rsspodcastfetcher.services.UserService;
import com.github.syndexmx.rsspodcastfetcher.usermodel.User;
import com.github.syndexmx.rsspodcastfetcher.usermodel.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .userName(userEntity.getUserName())
                .userPassword(userEntity.getUserPassword())
                .mail(userEntity.getMail())
                .build();
    }

    private UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .mail(user.getMail())
                .build();
    }

    @Override
    public boolean isUserExists(User user) {
        return userRepository.existsById(user.getUserName());
    }

    @Override
    public User save(User user) {
        final UserEntity userEntity = userToUserEntity(user);
        final UserEntity savedUserEntity = userRepository.save(userEntity);
        return userEntityToUser(savedUserEntity);
    }

    @Override
    public Optional<User> findById(String userName) {
        final Optional<UserEntity> foundUserEntity = userRepository.findById(userName);
        return foundUserEntity.map(userEntity -> userEntityToUser(userEntity));
    }

    @Override
    public List<User> listUsers() {
        final List<UserEntity> foundUsersEntities = userRepository.findAll();
        return foundUsersEntities.stream().map(userEntity
                -> userEntityToUser(userEntity)).toList();
    }

    @Override
    public void deleteStarById(String userName) {
        try {
            userRepository.deleteById(userName);
        } catch (EmptyResultDataAccessException e) {
            log.debug("Attempted to delete non-existent user", e);
        }

    }
}
