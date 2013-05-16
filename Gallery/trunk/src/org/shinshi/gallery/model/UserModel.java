package org.shinshi.gallery.model;

import java.io.Serializable;

/**
 * User: SpringNyan
 * Date: 13-4-16
 * Time: 下午10:04
 */
public class UserModel implements Serializable {
    private int id;
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;};

    private UserRole role;
    public UserRole getRole(){return this.role;}
    public void setRole(UserRole role){this.role = role;}

    private String name;
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    private String password;
    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    private String email;
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    private long joinedAt;
    public long getJoinedAt(){return  this.joinedAt;}
    public void setJoinedAt(long joinedAt){this.joinedAt = joinedAt;}

    private long lastLoginAt;
    public  long getLastLoginAt(){return this.lastLoginAt;}
    public void setLastLoginAt(long lastLoginAt){this.lastLoginAt = lastLoginAt;}
}
