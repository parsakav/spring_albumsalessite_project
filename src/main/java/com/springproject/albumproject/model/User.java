package com.springproject.albumproject.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
//Orm
@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotNull
    @NotEmpty(message = "*Please provide a user name")
    @Column(unique = true,name="user_name")
    private String username;
    @Temporal(TemporalType.DATE)
    @Column(name = "lastvotedate")
    private Date lastvotedate;
    @NotNull
    @NotEmpty(message = "*Please provide a password")
    @Column(unique = true,name="pass")
    private String password;
    @ManyToMany(fetch=FetchType.LAZY)
    //cascade =CascadeType.ALL
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    //cascade =CascadeType.ALL
    private Set<Invoice> invoices;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private Set<Vote> votes;
    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastvotedate() {
        return lastvotedate;
    }

    public void setLastvotedate(Date lastvotedate) {
        this.lastvotedate = lastvotedate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", invoices=" + invoices +
                ", votes=" + votes +
                '}';
    }
}