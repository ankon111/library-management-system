package com.vivacom.library.repository.book;

import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.dto.BookIssueDTO;
import com.vivacom.library.model.entity.BookIssue;

import java.util.List;

public interface IBookIssueAndSearchRepository {

    void saveBookIssued(BookIssue bookIssue);

    BookIssue getIssuedBookById(Integer issueId);

    BookIssue updateIssuedBook(BookIssue bookIssue);

    BookIssueDTO getIssuedBookListByBookId(int bookId);

    List<BookIssueDTO> getIssuedBookListByUserId(int id);

    List<BookDetailsDTO> getBookDeatilsBySearch(String keyWord, Integer searchBy);
}
