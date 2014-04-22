
package br.ufu.facom.lsi.dto.jsongen.videoratings;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Datum {

    @Expose
    private String id;
    @Expose
    private From from;
    @Expose
    private String start_time;
    @Expose
    private String end_time;
    @Expose
    private String publish_time;
    @Expose
    private Application application;
    @Expose
    private Data data;
    @Expose
    private String type;
    @Expose
    private Boolean no_feed_story;
    @Expose
    private Likes likes;
    @Expose
    private Comments comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getNo_feed_story() {
        return no_feed_story;
    }

    public void setNo_feed_story(Boolean no_feed_story) {
        this.no_feed_story = no_feed_story;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

}
