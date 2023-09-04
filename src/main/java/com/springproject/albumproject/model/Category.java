package com.springproject.albumproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
@Access(AccessType.FIELD)
public class Category {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name",unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
   private Set<Album> albumSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albumSet=" + albumSet +
                '}';
    }
}
