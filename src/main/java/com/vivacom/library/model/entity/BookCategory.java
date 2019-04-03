package com.vivacom.library.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "book_category")
public class BookCategory implements Serializable{

  @Id
  @Column(name = "category_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int categoryId;

  @NotNull(message = "{BookCategory.categoryName.empty}")
  @NotEmpty(message = "{BookCategory.categoryName.empty}")
  @Column(name = "category_name")
  private String categoryName;

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
