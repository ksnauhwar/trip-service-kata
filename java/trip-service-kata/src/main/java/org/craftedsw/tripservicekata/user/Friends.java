package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;

public class Friends {
    private List<User> friends;
    public Friends(){
        friends = new ArrayList<>();
    }
    public void add(User user){
        friends.add(user);
    }
    public boolean has(User user){
        return friends.contains(user);
    }
}
