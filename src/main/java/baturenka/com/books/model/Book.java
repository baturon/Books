package baturenka.com.books.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import jakarta.persistence.*;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "Book")
@Data
public class Book {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "date")
    private String date;
    @Column(name = "style")
    private String style;
    @Column(name = "numberOfPages")
    private int numberOfPages;
    @Column(name = "description")
    private String description;

    public Book(String title, String author
            , String date, String style
            , int numberOfPages, String description) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.style = style;
        this.numberOfPages = numberOfPages;
        this.description = description;
    }

    public Book() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", style='" + style + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", description='" + description + '\'' +
                '}';
    }
}
