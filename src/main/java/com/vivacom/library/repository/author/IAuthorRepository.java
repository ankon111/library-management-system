package com.vivacom.library.repository.author;

import com.vivacom.library.model.dto.AuthorDTO;
import com.vivacom.library.model.entity.Author;

import java.util.List;

/**
 * Created by Ankon on 10/18/2017.
 */
public interface IAuthorRepository {

    void saveAuthor(Author author);

    AuthorDTO getAuthor(int id);

    List<AuthorDTO> getAuthorList();
}
