package main.models;

import java.util.Objects;

public class Link {
    private String title;
    private String url;

    public Link(String title, String url) {
        this.title = title.trim();
        this.url = url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = new Link("", o.toString());
        return url.equals(link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
