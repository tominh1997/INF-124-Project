import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public  class BaseURI {
    public static URI getBaseURI() {

        //Change the URL here to make the client point to your service.
        return UriBuilder.fromUri("http://localhost:8080/chocoholic_REST_war_exploded/").build();
    }
}
