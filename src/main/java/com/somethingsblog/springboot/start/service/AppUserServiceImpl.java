package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.AppRole;
import com.somethingsblog.springboot.start.entity.AppUser;
import com.somethingsblog.springboot.start.repo.AppRoleRepo;
import com.somethingsblog.springboot.start.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService{
    private final AppUserRepo appUserRepo;
    private final AppRoleRepo appRoleRepo;

    public AppUserServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepo.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName,username);
        AppUser curAppUser = appUserRepo.findAppUserByUsername(username);
        AppRole curAppRole = appRoleRepo.findAppRoleByName(roleName);
        if(curAppUser.getRoles().contains(curAppRole)){
            curAppUser.getRoles().add(curAppRole);
        }
    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepo.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Got all users");
        return appUserRepo.findAll();
    }
}
