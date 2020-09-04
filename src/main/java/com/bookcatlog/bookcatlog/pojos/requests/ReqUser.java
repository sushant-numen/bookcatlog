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
public class ReqUser implements Serializable {
    @JsonProperty("userName")
    private  String userName;

    @JsonProperty("emailId")
    private  String emailId;

    @JsonProperty("mobileNumber")
    private  String mobileNumber;
}
