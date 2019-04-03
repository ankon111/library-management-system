package com.vivacom.library.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BookCategoryDTO implements Serializable{


  private int categoryId;

  @NotNull(message = "{BookCategory.categoryName.empty}")
  @NotEmpty(message = "{BookCategory.categoryName.empty}")
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
