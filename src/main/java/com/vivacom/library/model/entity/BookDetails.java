package com.vivacom.library.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "book_details")
public class BookDetails implements Serializable{

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bookId;

  @NotNull(message = "{BookDetails.bookName.empty}")
  @NotEmpty(message = "{BookDetails.bookName.empty}")
  @Column(name = "book_name")
  private String bookName;

  @NotNull(message = "{BookDetails.categoryId.empty}")
  @Column(name = "category_id")
  private Integer categoryId;

  @NotNull(message = "{BookDetails.authorId.empty}")
  @Column(name = "author_id")
  private Integer authorId;


  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
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

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }
}
