package model;

public class Book {
    private String title;
    private int id;
    private String author;
    private boolean isAvailable;
    
    public Book(int id, String title, String author){
        this.id = id;
        this.title=title;
        this.author=author;
        this.isAvailable=true;
    }
    public int getId(){ return id; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public boolean isAvailable(){ return isAvailable;}
    public void borrowBook(){ this.isAvailable=false;}
    public void returnBook(){ this.isAvailable=true;}

    @Override
    public String toString(){
        return "ID: "+ id + ", Title: "+title+", Author: "+author+ ", Available: "+ isAvailable;
    }
}
