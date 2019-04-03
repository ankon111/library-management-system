package com.vivacom.library.repository.book;

import com.vivacom.library.model.dto.BookCategoryDTO;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.entity.BookCategory;
import com.vivacom.library.model.entity.BookDetails;

import java.util.List;

/**
 * Created by Ankon on 10/19/2017.
 */
public interface IBooksAndCategoryRepository {
    void saveBookDetails(BookDetails bookDetails);

    List<BookDetailsDTO> getBookDetailsList();

    BookDetailsDTO getBookDetails(Integer bookId);

    void saveBookCategory(BookCategory bookCategory);

    BookCategoryDTO getBookCategory(int categoryId);

    List<BookCategoryDTO> getBookCategoryList();
}
