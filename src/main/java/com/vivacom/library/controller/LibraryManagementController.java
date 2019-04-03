package com.vivacom.library.controller;

import com.vivacom.library.constants.ConstantValues;
import com.vivacom.library.model.dto.*;
import com.vivacom.library.model.entity.Author;
import com.vivacom.library.model.entity.BookCategory;
import com.vivacom.library.model.entity.BookDetails;
import com.vivacom.library.model.entity.BookIssue;
import com.vivacom.library.service.author.IAuthorService;
import com.vivacom.library.service.book.IBookIssueAndSearchService;
import com.vivacom.library.service.book.IBooksAndCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by Ankon on 10/17/2017.
 */


@RestController
@RequestMapping(value = "/api/v1/library")
public class LibraryManagementController {


    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IBooksAndCategoryService booksAndCategoryService;

    @Autowired
    private IBookIssueAndSearchService bookIssueAndSearchService;

    @Autowired
    private MessageSource messageSource;


    /*************************Author********************************/
    /**
     *
     * @param authorDTO
     */
    @RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse saveAuthor(@RequestBody @Valid AuthorDTO authorDTO) throws Exception{
        authorService.saveAuthor(authorDTO);
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(messageSource.getMessage("author.save.success",null,null));
        return successResponse;
    }

    /**
     * @param authorId
     * @return
     */
    @RequestMapping(value = "/getAuthor/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDTO getAuthor(@PathVariable("id") Integer authorId)  throws Exception{
        return authorService.getAuthor(authorId);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAuthorList", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorDTO> getAuthorList()  throws Exception{
        return authorService.getAuthorList();
    }

    /*************************Book Category**********************************/


    @RequestMapping(value = "/saveBookCategory", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse saveBookCategory(@RequestBody @Valid BookCategoryDTO bookCategoryDTO) {
        booksAndCategoryService.saveBookCategory(bookCategoryDTO);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(messageSource.getMessage("bookcategory.save.success",null,null));
        return successResponse;
    }

    /**
     * @param bookCategoryId
     * @return
     */
    @RequestMapping(value = "/getBookCategory/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BookCategoryDTO getBookCategory(@PathVariable("id") Integer bookCategoryId) {
        return booksAndCategoryService.getBookCategory(bookCategoryId);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getBookCategoryList", method = RequestMethod.GET)
    @ResponseBody
    public List<BookCategoryDTO> getBookCategoryList() {
        return booksAndCategoryService.getBookCategoryList();
    }

    /*************************Book Details**********************************/


    @RequestMapping(value = "/saveBookDetails", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse saveBookDetails(@RequestBody @Valid BookDetailsDTO bookDetailsDTO) {
        booksAndCategoryService.saveBookDetails(bookDetailsDTO);
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(messageSource.getMessage("bookdetails.save.success",null,null));
        return successResponse;
    }


    /******************************
     * Book Issue
     *************************************/
    @RequestMapping(value = "/saveBookissue", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse saveBookissue(@RequestBody @Valid BookIssueDTO bookIssueDTO,Principal principal) {
        bookIssueAndSearchService.saveBookIssued(bookIssueDTO, principal.getName());
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(messageSource.getMessage("bookissue.save.success",null,null));
        return successResponse;
    }

    @RequestMapping(value = "/getIssuedBookListByUserId", method = RequestMethod.GET)
    @ResponseBody
    public List<BookIssueDTO> getIssuedBookListByUserId(Principal principal) {
        return bookIssueAndSearchService.getIssuedBookListByUserId(principal.getName());
    }

    /*****************************
     * Book Search
     *******************************/
    @RequestMapping(value = "/bookSearch", method = RequestMethod.POST)
    @ResponseBody
    public List<BookDetailsDTO> getBookDeatilsBySearch(@RequestBody @Valid SearchDTO searchDTO) {
        return bookIssueAndSearchService.getBookDeatilsBySearch(searchDTO.getKeyWord(), searchDTO.getSearchBy());
    }

    /****************************
     * Return issued Book
     ********************************************/
    @RequestMapping(value = "/returnIssuedBook", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse returnIssuedBook(@RequestBody BookDetailsDTO bookDetailsDTO,Principal principal) {
        bookIssueAndSearchService.returnIssuedBook(bookDetailsDTO, principal.getName());
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(messageSource.getMessage("bookissue.update.success",null,null));
        return successResponse;
    }

}
