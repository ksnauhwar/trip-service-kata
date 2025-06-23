package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTests {
    @Test
    public void shouldBeAFriendIfUserIsPresentInFriendsList(){
        User user = new User();
        User friend = new User();
        user.addFriend(friend);
        assertTrue(user.isFriendOf(friend));
    }

    @Test
    public void shouldNotBeAFriendIfUserIsPresentInFriendsList(){
        User user = new User();
        User notAFriend = new User();
        assertFalse(user.isFriendOf(notAFriend));
    }
}
