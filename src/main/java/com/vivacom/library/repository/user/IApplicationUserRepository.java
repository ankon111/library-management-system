package com.vivacom.library.repository.user;

import com.vivacom.library.model.entity.ApplicationUser;

public interface IApplicationUserRepository {


    void insertUser(ApplicationUser applicationUser);

    ApplicationUser getApplicationUserByUserName(String userName);
}
