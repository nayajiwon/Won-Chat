package com.jw.demo.DAO;

import lombok.Builder;
import lombok.Data;

@Data
public class SessionDao {

    private String Id;
    private int userId;

    @Builder
    public SessionDao(String Id, int userId){
        this.Id = Id;
    }
}
