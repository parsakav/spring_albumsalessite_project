package com.springproject.albumproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="singer")

@Access(AccessType.FIELD)
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="singer_id")
    private long id;
    @Column(name = "singer_fname")
    private String fname;
    @Column(name = "singer_lname")
    private String lname;
    @Column(name = "singer_nickname",unique = true)
    private String nickname;
    @OneToMany(mappedBy = "singer")
   private Set<Album> albums;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }


}
