package com.exercise.codingchallenge.service;

import com.exercise.codingchallenge.model.EmailList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

     private List<String>uniqueList;

    @Override
    public Integer getUniqueCount(List<String>emails) {
        uniqueList =new ArrayList<>();
             for (String e: emails){
                String email= removeOptionalChars(e);
                 addToUniqueList(email);
             }
        return  uniqueList.size();
    }


    private String removeOptionalChars(String email) {
        String userId = email.replace("@gmail.com", "").replace(".", "");
        String updatedUserId = null;
        if (userId.contains("+")) {
            return userId.substring(0, userId.indexOf("+")).toLowerCase();
        }

      return  userId.toLowerCase();
    }


   private void addToUniqueList(String email){

        if (!uniqueList.isEmpty()) {
            boolean unique=true;
            for (String e : uniqueList) {
                if (e.equalsIgnoreCase(email)) {
                    unique=false;
                    break;
                }
            }
            if(unique) {
                uniqueList.add(email);
            }
        }
       else {
            uniqueList.add(email);
        }

    }



}
