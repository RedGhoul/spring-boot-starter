package com.somethingsblog.springboot.start.repo;

import com.somethingsblog.springboot.start.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String username);
}
