
package br.ufu.facom.lsi.dto.jsongen.videoratings;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class VideoRatings {

    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @Expose
    private Paging_ paging;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Paging_ getPaging() {
        return paging;
    }

    public void setPaging(Paging_ paging) {
        this.paging = paging;
    }

}
