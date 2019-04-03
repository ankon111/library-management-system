package com.vivacom.library.service.user;

import com.vivacom.library.model.entity.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Ankon on 10/17/2017.
 */
public interface IApplicationUserService {

    void insertUser(ApplicationUser applicationUser);

    ApplicationUser getApplicationUserByUserName(String userName);
}
