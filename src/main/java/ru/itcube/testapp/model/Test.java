package ru.itcube.testapp.model;

import java.util.List;
import java.util.StringJoiner;

public class Test {

    private long id;
    private String title;
    private List<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return new StringJoiner(", ", Test.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("title='" + title + "'")
            .toString();
    }
}
