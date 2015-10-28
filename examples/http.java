import org.slf4j.Logger;
import com.fizzed.blaze.Contexts;
import com.fizzed.blaze.http.UriBuilder;
import java.net.URI;
import org.apache.http.client.fluent.Request;

public class http {

    public void main() throws Exception {
        Logger log = Contexts.logger();
        
        URI uri = UriBuilder.of("http://api.theysaidso.com/qod.json")
            .query("category", "management")
            .build();
        
        String output = 
            Request.Get(uri)
                .execute()
                .returnContent()
                .toString();
        
        log.info("Quote of the day JSON is {}", output);
    };
    
}