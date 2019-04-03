package com.vivacom.library.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Ankon on 10/19/2017.
 */
public class BookDetailsDTO {

    private Integer bookId;

    @NotNull(message = "{BookDetails.bookName.empty}")
    @NotEmpty(message = "{BookDetails.bookName.empty}")
    private String bookName;

    @NotNull(message = "{BookDetails.categoryId.empty}")
    private Integer categoryId;

    private String categoryName;

    @NotNull(message = "{BookDetails.authorId.empty}")
    private Integer authorId;

    private String authorName;
    private String issueStatus;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}
