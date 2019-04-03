package com.vivacom.library.repository.user;

import com.vivacom.library.model.dto.BookIssueDTO;
import com.vivacom.library.model.entity.ApplicationUser;
import com.vivacom.library.repository.common.BaseRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationUserRepository extends BaseRepository implements IApplicationUserRepository {


    @Override
    public void insertUser(ApplicationUser applicationUser) {
        em.persist(applicationUser);
    }

    @Override
    public ApplicationUser getApplicationUserByUserName(String userName) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT a.id as id,a.username as username,a.password as password,a.fullname as fullname FROM library.user a ");
        builder.append(" WHERE a.username = :userName");

        Query hQuery = hibernateQuery(builder.toString(), ApplicationUser.class);
        hQuery.setParameter("userName", userName);

        List<ApplicationUser> userList =  hQuery.list();
        return (userList == null || userList.isEmpty())?null:userList.get(0);
    }
}
