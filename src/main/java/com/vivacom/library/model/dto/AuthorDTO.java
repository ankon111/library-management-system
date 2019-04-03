package com.vivacom.library.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AuthorDTO implements Serializable{


  private int authorId;

  @NotNull(message = "{Author.authorName.empty}")
  @NotEmpty(message = "{Author.authorName.empty}")
  private String authorName;

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
}
