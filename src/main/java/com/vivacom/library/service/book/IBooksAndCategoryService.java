package com.vivacom.library.service.book;

import com.vivacom.library.model.dto.BookCategoryDTO;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.entity.BookDetails;
import com.vivacom.library.model.entity.BookCategory;

import java.util.List;

/**
 * Created by Ankon on 10/19/2017.
 */
public interface IBooksAndCategoryService {

    void saveBookDetails(BookDetailsDTO bookDetailsDTO) ;

    void saveBookCategory(BookCategoryDTO bookCategoryDTO) ;

    BookCategoryDTO getBookCategory(Integer bookCategoryId) ;

    List<BookCategoryDTO> getBookCategoryList() ;

}
