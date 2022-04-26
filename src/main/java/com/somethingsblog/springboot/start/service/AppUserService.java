package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.AppRole;
import com.somethingsblog.springboot.start.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
