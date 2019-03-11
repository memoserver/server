package com.memo.server.entity.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserSelf extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String account;

    private String password;

    private int accountType;

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
