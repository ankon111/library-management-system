package com.vivacom.library.service.author;

import com.vivacom.library.model.dto.AuthorDTO;
import com.vivacom.library.model.entity.Author;

import java.util.List;

/**
 * Created by Ankon on 10/18/2017.
 */
public interface IAuthorService {

    void saveAuthor(AuthorDTO authorDTO);

    AuthorDTO getAuthor(Integer id);

    List<AuthorDTO> getAuthorList();
}
