package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirendsUnitTests {
    @Test
    public void shouldBeAFriendIfPresentInFriendsList() {
        Friends friends = new Friends();
        User user = new User();
        friends.add(user);
        assertTrue(friends.has(user));
    }

    @Test
    public void shouldNotBeAFriendIfPresentInFriendsList() {
        Friends friends = new Friends();
        User user = new User();
        assertFalse(friends.has(user));
    }
}
