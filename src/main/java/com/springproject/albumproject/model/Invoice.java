package com.springproject.albumproject.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="invoiced")
@Access(AccessType.FIELD)

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long id;
    @Column(name = "invoice_number")

    private Integer number;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
@ManyToMany()
@JoinTable(name = "invoice_album",
        joinColumns = @JoinColumn(name = "invoiced_id"),
        inverseJoinColumns = @JoinColumn(name = "album_id"))
    private Set<Album> albumSet;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", user=" + user +
                ", albumSet=" + albumSet +
                '}';
    }
}
