package org.gfg.TransactionService;

import org.gfg.Utils.CommonConstants;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServicu implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        once i got here all i need to do is basic stuff
//         but why i want all the details of user here
        // in simpler words what if you require some other stuff from the user so letts goand bring the stuff
// from user
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setBasicAuth("txnserive","wertyuio");
        HttpEntity request = new HttpEntity(httpHeaders);
     JSONObject jsonObject= restTemplate.exchange("http://localhost:8080/user/contact?contact="+ username, HttpMethod.GET,request, JSONObject.class).getBody();
//        to the point where i hit the data from other center
String contact = (String) jsonObject.get(CommonConstants.USER_CREATION_TOPIC_CONTACT);


    }
//    dont watch your phone write your all doubts here
//    so lemma catch me this one
//    whaqt my transaction going to need need to implement the java mails sender at all ends and thqat uppdation of tablle quering is good
//
}
