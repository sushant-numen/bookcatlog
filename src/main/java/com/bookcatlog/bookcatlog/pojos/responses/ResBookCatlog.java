package com.bookcatlog.bookcatlog.pojos.responses;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
public class ResBookCatlog implements Serializable {
    private  String status;
    public ResBookCatlog (String status){
        this.status=status;
    }
}
