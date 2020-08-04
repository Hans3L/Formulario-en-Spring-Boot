package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.entity.UserEntity;
import com.creativity.registrymicroservice.entity.UserRoleEntity;
import com.creativity.registrymicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImp implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        List<GrantedAuthority> authorities = buildAuthorities(userEntity.getUserRole());
        return buildUser(userEntity,authorities);
    }

    private User buildUser(UserEntity user, List<GrantedAuthority> authorities) {
        return new User(user.getUserName(),user.getPassword(),user.isEnable(),
                true,true,true,authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRoleEntity> userRoleEntitySet) {
        Set<GrantedAuthority> auths = new HashSet();
        for (UserRoleEntity userRoleEntity : userRoleEntitySet)
            auths.add(new SimpleGrantedAuthority(userRoleEntity.getRole()));
        return new ArrayList<>(auths);
    }
}
