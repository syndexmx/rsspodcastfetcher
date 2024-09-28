package com.github.syndexmx.rsspodcastfetcher.services;

import com.github.syndexmx.rsspodcastfetcher.usermodel.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    boolean isUserExists(User user);

    User save(User user);

    Optional<User> findById(String userName);

    List<User> listUsers();

    void deleteStarById(String userName);
}
