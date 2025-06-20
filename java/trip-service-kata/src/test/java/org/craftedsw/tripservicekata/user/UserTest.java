package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void shouldReturnTrueIfUserIsAFriend(){
        User user = new User();
        User friend = new User();
        user.addFriend(friend);
        assertTrue(user.isFriendOf(friend));
    }

    @Test
    public void shouldReturnFalseIfUserIsNotAFriend(){
        User user = new User();
        User notAFriend = new User();
        assertFalse(user.isFriendOf(notAFriend));
    }
}
