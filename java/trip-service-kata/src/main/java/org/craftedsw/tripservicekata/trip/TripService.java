package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripFor(User user) throws UserNotLoggedInException {
        if (UserSession.getInstance().getLoggedUser() == null) throw new UserNotLoggedInException();

        return user.isFriendOf(UserSession.getInstance().getLoggedUser()) ? TripDAO.findTripsByUser(user)
                : new ArrayList<>();
    }

}
