package com.vivacom.library.service.book;

import com.vivacom.library.customexception.BookDetailsInvalidException;
import com.vivacom.library.customexception.BookIssuedException;
import com.vivacom.library.enumeratin.IssueStatus;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.dto.BookIssueDTO;
import com.vivacom.library.model.entity.ApplicationUser;
import com.vivacom.library.model.entity.BookIssue;
import com.vivacom.library.repository.book.IBookIssueAndSearchRepository;
import com.vivacom.library.repository.book.IBooksAndCategoryRepository;
import com.vivacom.library.repository.user.IApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookIssueAndSearchService implements IBookIssueAndSearchService {

    @Autowired
    private IBookIssueAndSearchRepository bookIssueAndSearchRepository;

    @Autowired
    private IBooksAndCategoryRepository booksAndCategoryRepository;

    @Autowired
    IApplicationUserRepository applicationUserRepository;

    @Autowired
    private MessageSource messageSource;

    @Transactional
    @Override
    public void saveBookIssued(BookIssueDTO bookIssueDTO, String userName)  {

        BookDetailsDTO bookDetailsDTO = booksAndCategoryRepository.getBookDetails(bookIssueDTO.getBookId());
        if (bookDetailsDTO == null) {
            throw new BookDetailsInvalidException(messageSource.getMessage("BookDetails.bookId.invalid", null, null));
        }

        BookIssueDTO checkBookIssueDTO = bookIssueAndSearchRepository.getIssuedBookListByBookId(bookIssueDTO.getBookId());
        if (checkBookIssueDTO != null) {
            throw new BookIssuedException(messageSource.getMessage("BookIssue.saveBookIssued.request", null, null));
        }

        if (new Date().compareTo(bookIssueDTO.getDueDate()) > 0) {
            throw new BookIssuedException(messageSource.getMessage("BookIssue.issueandduedate.invalid", null, null));
        }

        ApplicationUser applicationUser = applicationUserRepository.getApplicationUserByUserName(userName);
        BookIssue bookIssue = new BookIssue();
        bookIssue.setUserId(applicationUser.getId());
        bookIssue.setBookId(bookIssueDTO.getBookId());
        bookIssue.setIssueDate(new Date());
        bookIssue.setDueDate(bookIssueDTO.getDueDate());
        bookIssue.setIssueStatus(IssueStatus.BORROWED.getValue());
        bookIssueAndSearchRepository.saveBookIssued(bookIssue);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookIssueDTO> getIssuedBookListByUserId(String userName)  {
        ApplicationUser applicationUser = applicationUserRepository.getApplicationUserByUserName(userName);
        List<BookIssueDTO> bookIssueDTOList = bookIssueAndSearchRepository.getIssuedBookListByUserId(applicationUser.getId());
        if (bookIssueDTOList == null || bookIssueDTOList.size() == 0) {
            throw new BookIssuedException(messageSource.getMessage("BookIssue.getIssuedBookListByUserId.invalid", null, null));
        }

        return bookIssueDTOList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDetailsDTO> getBookDeatilsBySearch(String keyWord, Integer searchBy)  {
        return bookIssueAndSearchRepository.getBookDeatilsBySearch(keyWord, searchBy);
    }

    @Transactional
    @Override
    public BookIssue returnIssuedBook(BookDetailsDTO bookDetailsDTO, String userName)  {

        if(bookDetailsDTO.getBookId() == null){
            throw new BookIssuedException(messageSource.getMessage("BookIssue.bookId.empty", null, null));
        }

        ApplicationUser applicationUser = applicationUserRepository.getApplicationUserByUserName(userName);
        List<BookIssueDTO> bookIssueDTOList = bookIssueAndSearchRepository.getIssuedBookListByUserId(applicationUser.getId());
        Boolean check = bookIssueDTOList.stream().
                filter(u -> u.getUserId() == applicationUser.getId() && u.getBookId() == bookDetailsDTO.getBookId() && u.getIssueStatus() == IssueStatus.BORROWED.getValue()).findFirst().isPresent();
        if (!check) {
            throw new BookIssuedException(messageSource.getMessage("BookIssue.invlaidbookissue.invalid", null, null));
        }
        BookIssue bookIssue = bookIssueAndSearchRepository.getIssuedBookById(bookIssueDTOList.stream().
                filter(u -> u.getUserId() == applicationUser.getId() && u.getBookId() == bookDetailsDTO.getBookId() && u.getIssueStatus() == IssueStatus.BORROWED.getValue()).findFirst().get().getIssueId());
        bookIssue.setReturnDate(new Date());
        bookIssue.setIssueStatus(IssueStatus.RETURNED.getValue());
        return bookIssueAndSearchRepository.updateIssuedBook(bookIssue);
    }

}
