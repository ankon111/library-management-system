package com.vivacom.library.model.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookIssueDTO {

    private Integer issueId;
    private Integer userId;

    @NotNull(message = "{BookIssue.bookId.empty}")
    private Integer bookId;
    private String bookName;
    private Integer authorId;
    private String authorName;
    private Integer categoryId;
    private String categoryName;

    private Date issueDate;

    @NotNull(message = "{BookIssue.dueDate.empty}")
    private Date dueDate;
    private Date returnDate;
    private Character issueStatus;

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Character getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(Character issueStatus) {
        this.issueStatus = issueStatus;
    }
}
