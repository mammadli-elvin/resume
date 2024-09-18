package com.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authority_role")
public class AuthorityRole {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "authority_id")
    private Integer authorityId;

    @Column(name = "role_id")
    private Integer roleId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "AuthorityRole{" +
                "id=" + id + '\'' +
                "authorityId=" + authorityId + '\'' +
                "roleId=" + roleId + '\'' +
                '}';
    }
}
