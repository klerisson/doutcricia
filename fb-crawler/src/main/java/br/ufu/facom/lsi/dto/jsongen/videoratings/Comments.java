
package br.ufu.facom.lsi.dto.jsongen.videoratings;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Comments {

    @Expose
    private Integer count;
    @Expose
    private Boolean can_comment;
    @Expose
    private String comment_order;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getCan_comment() {
        return can_comment;
    }

    public void setCan_comment(Boolean can_comment) {
        this.can_comment = can_comment;
    }

    public String getComment_order() {
        return comment_order;
    }

    public void setComment_order(String comment_order) {
        this.comment_order = comment_order;
    }

}
