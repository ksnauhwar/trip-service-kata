package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	//keeping trips for now since the domain states that
	//a user has trips and friends
	private List<Trip> trips = new ArrayList<Trip>();

	private Friends friends = new Friends();

	public boolean isFriendOf(User user) {
		return friends.has(user);
	}

	public void addFriend(User user) {
		friends.add(user);
	}
}
