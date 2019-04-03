package com.vivacom.library.service.book;

import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.dto.BookIssueDTO;
import com.vivacom.library.model.entity.BookIssue;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookIssueAndSearchService {

    void saveBookIssued(BookIssueDTO bookIssueDTO,String userName) ;

    List<BookIssueDTO> getIssuedBookListByUserId(String userName) ;

    List<BookDetailsDTO> getBookDeatilsBySearch(String keyWord, Integer searchBy) ;

    BookIssue returnIssuedBook(BookDetailsDTO bookDetailsDTO, String userName) ;
}
