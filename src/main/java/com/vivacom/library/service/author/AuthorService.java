package com.vivacom.library.service.author;

import com.vivacom.library.customexception.AuthorInvalidException;
import com.vivacom.library.model.dto.AuthorDTO;
import com.vivacom.library.model.entity.Author;
import com.vivacom.library.repository.author.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankon on 10/18/2017.
 */
@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Autowired
    private MessageSource messageSource;

    //@CacheEvict(value = "author", allEntries = true)
    @Transactional
    @Override
    public void saveAuthor(AuthorDTO authorDTO){
        List<AuthorDTO> authorList = getAuthorList();
        Boolean check = authorList.stream().filter(x -> x.getAuthorName().equalsIgnoreCase(authorDTO.getAuthorName())).findFirst().isPresent();
        if (check) {
            throw new AuthorInvalidException(messageSource.getMessage("Author.authorName.exist", null, null));
        }

        Author author = new Author();
        author.setAuthorName(authorDTO.getAuthorName());

        authorRepository.saveAuthor(author);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthorDTO getAuthor(Integer id) {
        if (id == null) {
            throw new AuthorInvalidException(messageSource.getMessage("Author.authorId.invalid", null, null));
        }

        AuthorDTO authorDTO = authorRepository.getAuthor(id);
        if (authorDTO == null) {
            throw new AuthorInvalidException(messageSource.getMessage("Author.authorId.invalid", null, null));
        }

        return authorDTO;
    }

    // @Cacheable(cacheNames = "author")
    @Transactional(readOnly = true)
    @Override
    public List<AuthorDTO> getAuthorList(){
        return authorRepository.getAuthorList();
    }


}
