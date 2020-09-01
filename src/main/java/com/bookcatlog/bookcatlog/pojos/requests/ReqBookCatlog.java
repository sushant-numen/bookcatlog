package com.bookcatlog.bookcatlog.pojos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqBookCatlog implements Serializable {

    @JsonProperty("bookName")
    private  String bookName;

    @JsonProperty("author")
    private  String author;

    @JsonProperty("bookId")
    private  int bookId;


}
