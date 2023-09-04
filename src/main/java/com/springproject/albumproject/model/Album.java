package com.springproject.albumproject.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "album")
@Access(AccessType.FIELD)
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private long id;
    @Column(name = "album_name")
    private String albumname;
    @Column(name = "album_releasedate")
    private Date albbumreleasedate;
    @Column(name = "album_price")
    private Long albumprice;
    @Column(name = "album_sam")
    private String albom_sam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "category_album")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;
    @OneToMany(mappedBy = "album")
    private Set<Vote> vote;
    @ManyToMany(mappedBy = "albumSet")

    private Set<Invoice> invoices;
    @Column(name="counter")
    @ColumnDefault("0")
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Transient
private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public Date getAlbbumreleasedate() {
        return albbumreleasedate;
    }

    public void setAlbbumreleasedate(Date albbumreleasedate) {
        this.albbumreleasedate = albbumreleasedate;
    }

    public long getAlbumprice() {
        return albumprice;
    }

    public void setAlbumprice(Long albumprice) {
        this.albumprice = albumprice;
    }

    public String getAlbom_sam() {
        return albom_sam;
    }

    public void setAlbom_sam(String albom_sam) {
        this.albom_sam = albom_sam;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Set<Vote> getVote() {
        return vote;
    }

    public void setVote(Set<Vote> vote) {
        this.vote = vote;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
