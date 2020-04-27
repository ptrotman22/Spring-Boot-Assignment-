package com.example.Video_Game_Label.entity;

import javax.persistence.*;

//VideoGameLabel Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "Video_Game_Label") //This is for the actual name of the database table we are mapping to the class.
public class VideoGameLabel {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "title") //This will map the firstName field to the column named title in the table.
    private String title;

    @Column(name = "genre") //This will map the firstName field to the column named genre in the table.
    private String genre;

    @Column(name = "publisher") //This will map the lastName field to the column named publisher in the table.
    private String publisher;

    @Column(name = "developer") //This will map the email field to the column named developer in the table.
    private String developer;

    //default constructor
    public VideoGameLabel() {
    }

    //para constructor
    public VideoGameLabel(int id, String title, String genre, String publisher, String developer) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.developer = developer;
    }

    //getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    //ToString Method
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + developer +
                '}';
    }
}
