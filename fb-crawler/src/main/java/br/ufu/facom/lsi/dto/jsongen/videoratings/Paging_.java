
package br.ufu.facom.lsi.dto.jsongen.videoratings;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Paging_ {

    @Expose
    private String next;

    @Expose
    private String previous;
    
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

}
