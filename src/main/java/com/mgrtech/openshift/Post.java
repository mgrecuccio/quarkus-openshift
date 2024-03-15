package com.mgrtech.openshift;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Date;
import java.util.Objects;

@RegisterForReflection
@MongoEntity(collection = "Posts")
public class Post extends PanacheMongoEntity {

    private String title;
    private String content;
    private long timestamp;

    public Post() {}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
        this.timestamp = new Date().getTime();
    }

    public String getTitle() {
        return new StringBuilder(title).reverse().toString(); // Should be: return title;
    }

    public String getContent() {
        return new StringBuilder(content).reverse().toString(); // Should be: return content;
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return timestamp == post.timestamp &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, timestamp);
    }
}
