package com.jw.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

@Data //lombok을 사용하겠다.
@AllArgsConstructor //가능한 모든 타입의 생성자를 가능하게 해줌
public class SearchParam {
    private String account;
    private String email;
    private int page;

    /*
    public String getAccount() {
        return account;
    }

    public String getEmail() {
        return email;
    }

    public int getPage() {
        return page;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPage(int page) {
        this.page = page;
    }*/
}
