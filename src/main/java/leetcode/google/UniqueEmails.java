package leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UniqueEmails {

    @Test
    public void findNumberOfEmails(){
        String[] emails = new String[3];
        emails[0] = "test.email+alex@leetcode.com";
        emails[1] = "test.e.mail+bob.cathy@leetcode.com";
        emails[2] = "testemail+david@lee.tcode.com";
        int c = numUniqueEmails(emails);
        assertEquals(2, c);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for(String email: emails) {
            int at = email.indexOf('@');
            String personal = email.substring(0, at);
            String domain = email.substring(at);
            int plusIndex = personal.indexOf('+');
            if(plusIndex != -1){
                personal = personal.substring(0, plusIndex);
            }
            personal = personal.replace(".", "");
            res.add(personal+domain);
        }
        return res.size();
    }
}
