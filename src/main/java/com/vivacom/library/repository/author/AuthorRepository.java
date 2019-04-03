package com.vivacom.library.repository.author;

import com.vivacom.library.model.dto.AuthorDTO;
import com.vivacom.library.model.entity.Author;
import com.vivacom.library.repository.common.BaseRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Ankon on 10/18/2017.
 */
@Repository
public class AuthorRepository extends BaseRepository implements IAuthorRepository {


    @Override
    public void saveAuthor(Author author) {
        em.persist(author);
    }

    @Override
    public AuthorDTO getAuthor(int id) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.author_id authorId,A.author_name authorName FROM author A WHERE A.author_id = :authorId");
        Query hQuery = hibernateQuery(query.toString(), AuthorDTO.class);
        hQuery.setParameter("authorId", id);
        List<AuthorDTO> authorDtoList =  hQuery.list();
        return (authorDtoList == null || authorDtoList.isEmpty())?null:authorDtoList.get(0);
    }

    @Override
    public List<AuthorDTO> getAuthorList() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.author_id authorId,A.author_name authorName FROM author A");
        Query hQuery = hibernateQuery(query.toString(), AuthorDTO.class);
        List<AuthorDTO> authorDtoList =  hQuery.list();
        return (authorDtoList == null || authorDtoList.isEmpty())?null:authorDtoList;
    }
}
