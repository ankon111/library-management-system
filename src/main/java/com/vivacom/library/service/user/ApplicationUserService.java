package com.vivacom.library.service.user;

import com.vivacom.library.customexception.UserNotFoundException;
import com.vivacom.library.model.entity.ApplicationUser;
import com.vivacom.library.repository.user.IApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Collections.emptyList;

/**
 * Created by Ankon on 10/17/2017.
 */
@Service
public class ApplicationUserService implements IApplicationUserService, UserDetailsService {

    @Autowired
    IApplicationUserRepository applicationUserRepository;

    @Autowired
    private MessageSource messageSource;

    @Transactional
    @Override
    public void insertUser(ApplicationUser applicationUser) {

        if (applicationUser.getUsername().equalsIgnoreCase("null")) {
            throw new UserNotFoundException(messageSource.getMessage("applicationuser.user.null", null, null));
        }

        ApplicationUser existUser = applicationUserRepository.getApplicationUserByUserName(applicationUser.getUsername());
        if (existUser != null) {
            throw new UserNotFoundException(messageSource.getMessage("applicationuser.user.exist", null, null));
        }
        applicationUserRepository.insertUser(applicationUser);
    }

    @Override
    public ApplicationUser getApplicationUserByUserName(String userName) {
        return applicationUserRepository.getApplicationUserByUserName(userName);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.getApplicationUserByUserName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.withUsername(applicationUser.getUsername())
                .password(applicationUser.getPassword())
                .authorities(emptyList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
//        new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

}
