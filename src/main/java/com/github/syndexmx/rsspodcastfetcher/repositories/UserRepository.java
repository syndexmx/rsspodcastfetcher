package com.github.syndexmx.rsspodcastfetcher.repositories;

import com.github.syndexmx.rsspodcastfetcher.usermodel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
