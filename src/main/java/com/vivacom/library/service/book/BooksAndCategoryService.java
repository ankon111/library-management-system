package com.vivacom.library.service.book;

import com.vivacom.library.customexception.AuthorInvalidException;
import com.vivacom.library.customexception.BookCategoryInvalidException;
import com.vivacom.library.customexception.BookDetailsInvalidException;
import com.vivacom.library.model.dto.AuthorDTO;
import com.vivacom.library.model.dto.BookCategoryDTO;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.entity.BookCategory;
import com.vivacom.library.model.entity.BookDetails;
import com.vivacom.library.repository.book.IBooksAndCategoryRepository;
import com.vivacom.library.service.author.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankon on 10/19/2017.
 */
@Service
public class BooksAndCategoryService implements IBooksAndCategoryService {

    @Autowired
    IBooksAndCategoryRepository booksAndCategoryRepository;

    @Autowired
    IAuthorService authorService;

    @Autowired
    MessageSource messageSource;


    @Transactional
    @Override
    public void saveBookDetails(BookDetailsDTO bookDetailsDTO)  {
        List<BookDetailsDTO> bookDetailsDTOList = booksAndCategoryRepository.getBookDetailsList();
        Boolean check = bookDetailsDTOList.stream().filter(x -> (x.getBookName().equalsIgnoreCase(bookDetailsDTO.getBookName())) &&
                (x.getAuthorId() == bookDetailsDTO.getAuthorId())).findFirst().isPresent();
        if (check) {
            throw new BookDetailsInvalidException(messageSource.getMessage("BookDetails.bookAndAuthorName.exist", null, null));
        }

        BookCategoryDTO bookCategoryDTO = booksAndCategoryRepository.getBookCategory(bookDetailsDTO.getCategoryId());
        if (bookCategoryDTO == null) {
            throw new BookCategoryInvalidException(messageSource.getMessage("BookCategory.categoryId.invalid", null, null));
        }

        AuthorDTO author = authorService.getAuthor(bookDetailsDTO.getAuthorId());
        if (author == null) {
            throw new AuthorInvalidException(messageSource.getMessage("Author.authorId.invalid", null, null));
        }

        BookDetails bookDetails = new BookDetails();
        bookDetails.setBookName(bookDetailsDTO.getBookName());
        bookDetails.setCategoryId(bookDetailsDTO.getCategoryId());
        bookDetails.setAuthorId(bookDetailsDTO.getAuthorId());

        booksAndCategoryRepository.saveBookDetails(bookDetails);
    }


    /**
     * @param bookCategoryDTO
     */
    @Transactional
    @Override
    public void saveBookCategory(BookCategoryDTO bookCategoryDTO)  {

        List<BookCategoryDTO> bookCategoryList = getBookCategoryList();
        Boolean check = bookCategoryList.stream().filter(x -> x.getCategoryName().equalsIgnoreCase(bookCategoryDTO.getCategoryName())).findFirst().isPresent();
        if (check) {
            throw new BookCategoryInvalidException(messageSource.getMessage("BookCategory.categoryName.exist", null, null));
        }

        BookCategory bookCategory = new BookCategory();
        bookCategory.setCategoryName(bookCategoryDTO.getCategoryName());

        booksAndCategoryRepository.saveBookCategory(bookCategory);
    }

    /**
     * @param bookCategoryId
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public BookCategoryDTO getBookCategory(Integer bookCategoryId)  {

        if (bookCategoryId == null) {
            throw new BookCategoryInvalidException(messageSource.getMessage("BookCategory.categoryId.invalid", null, null));
        }

        BookCategoryDTO bookCategoryDTO = booksAndCategoryRepository.getBookCategory(bookCategoryId);
        if (bookCategoryDTO == null) {
            throw new BookCategoryInvalidException(messageSource.getMessage("BookCategory.categoryId.invalid", null, null));
        }
        return bookCategoryDTO;
    }

    /**
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<BookCategoryDTO> getBookCategoryList() {
        return booksAndCategoryRepository.getBookCategoryList();
    }
}
