package com.somethingsblog.springboot.start.repo;

import com.somethingsblog.springboot.start.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findAppRoleByName(String name);
}

