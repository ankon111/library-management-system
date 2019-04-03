package com.vivacom.library.model.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Ankon on 10/19/2017.
 */
public class SearchDTO {

    @NotNull(message = "{SearchDTO.keyWord.empty}")
    private String keyWord;

    @NotNull(message = "{SearchDTO.searchBy.empty}")
    private Integer searchBy;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(Integer searchBy) {
        this.searchBy = searchBy;
    }
}
