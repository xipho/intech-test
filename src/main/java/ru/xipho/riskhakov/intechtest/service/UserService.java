package ru.xipho.riskhakov.intechtest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.xipho.riskhakov.intechtest.dao.Role;
import ru.xipho.riskhakov.intechtest.dao.User;
import ru.xipho.riskhakov.intechtest.dto.UserDto;
import ru.xipho.riskhakov.intechtest.jpa.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> loadUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public void createUser(UserDto userDto, BindingResult result) {
        User user = userRepo.findByUsername(userDto.getUsername());
        if (user != null) {
            result.rejectValue("user", "This username already taken!");
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user = new User(userDto.getUsername(), bCryptPasswordEncoder.encode(userDto.getPassword()), true, Collections.singleton(Role.USER));
            userRepo.save(user);
        }
    }
}
