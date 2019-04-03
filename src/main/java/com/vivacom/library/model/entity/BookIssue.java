package com.vivacom.library.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book_issue")
public class BookIssue implements Serializable{

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int issueId;

  @Column(name = "user_id")
  private Integer userId;

  @NotNull(message = "{BookIssue.bookId.empty}")
  @Column(name = "book_id")
  private Integer bookId;

  @Column(name = "issue_date")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date issueDate;

  @NotNull(message = "{BookIssue.dueDate.empty}")
  @Column(name = "due_date")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date dueDate;

  @Column(name = "return_date")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date returnDate;

  @Column(name = "issue_status")
  private char issueStatus;


  public int getIssueId() {
    return issueId;
  }

  public void setIssueId(int issueId) {
    this.issueId = issueId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
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

  public char getIssueStatus() {
    return issueStatus;
  }

  public void setIssueStatus(char issueStatus) {
    this.issueStatus = issueStatus;
  }
}
