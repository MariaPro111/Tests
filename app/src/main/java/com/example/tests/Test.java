package com.example.tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test  implements Serializable{
    private Long id;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Test(Long id, String title){
        this.id = id;
        this.title=title;
    }

    //public Test(String title){
      //this.title=title;
    //}



    public Long getId() { return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
   public String toString() {
       return "Test{" +
               "id=" + id +
               ", title='" + title + '\'' +
                '}';
    }
}
