package com.dox.cloud.storeauthserver.repository;

import com.dox.cloud.storeauthserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String s);
}
