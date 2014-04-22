
package br.ufu.facom.lsi.dto.jsongen.videoratings;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Likes {

    @Expose
    private List<Datum_> data = new ArrayList<Datum_>();
    @Expose
    private Paging paging;
    @Expose
    private Integer count;
    @Expose
    private Boolean can_like;
    @Expose
    private Boolean user_likes;

    public List<Datum_> getData() {
        return data;
    }

    public void setData(List<Datum_> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getCan_like() {
        return can_like;
    }

    public void setCan_like(Boolean can_like) {
        this.can_like = can_like;
    }

    public Boolean getUser_likes() {
        return user_likes;
    }

    public void setUser_likes(Boolean user_likes) {
        this.user_likes = user_likes;
    }

}
