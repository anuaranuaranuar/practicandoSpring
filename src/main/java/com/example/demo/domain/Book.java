package com.example.demo.domain;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class Book{
    private String title;
    private List<Author> authors;
    private List<String> summaries;
    private List<String> personages;
    private List<String> categories;
    private Map<String, URI> formats;
    private BigInteger downloadCount;

    public Book(String title, List<Author> authors, List<String> summaries, List<String> personages,
            List<String> categories, Map<String, URI> formats, BigInteger downloadCount) {
        this.title = title;
        this.authors = authors;
        this.summaries = summaries;
        this.personages = personages;
        this.categories = categories;
        this.formats = formats;
        this.downloadCount = downloadCount;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<String> summaries) {
        this.summaries = summaries;
    }

    public List<String> getPersonages() {
        return personages;
    }

    public void setPersonages(List<String> personages) {
        this.personages = personages;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Map<String, URI> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, URI> formats) {
        this.formats = formats;
    }

    public BigInteger getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(BigInteger downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "(title=" + title +
                ", authors=" + authors +
                ", summaries=" + summaries +
                ", personages=" + personages +
                ", categories=" + categories +
                ", formats=" + formats +
                ", downloadCount=" + downloadCount + ")";
    }

    


 

}