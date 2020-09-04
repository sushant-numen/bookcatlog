package com.bookcatlog.bookcatlog.pojos.responses;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
public class ResUser implements Serializable {
    private  String status;
    private  Integer id;
    public ResUser (String status,Integer id){
        this.status=status;
        this.id=id;
    }


}
