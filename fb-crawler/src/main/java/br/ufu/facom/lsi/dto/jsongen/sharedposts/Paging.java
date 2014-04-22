
package br.ufu.facom.lsi.dto.jsongen.sharedposts;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Paging {

    @Expose
    private Cursors cursors;

    public Cursors getCursors() {
        return cursors;
    }

    public void setCursors(Cursors cursors) {
        this.cursors = cursors;
    }

}
