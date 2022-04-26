package com.somethingsblog.springboot.start.service;

import com.somethingsblog.springboot.start.entity.AppUser;
import com.somethingsblog.springboot.start.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    AppUserRepo userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findAppUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User Not Found with username: " + username);
        return UserDetailsImpl.build(user);
    }
}
