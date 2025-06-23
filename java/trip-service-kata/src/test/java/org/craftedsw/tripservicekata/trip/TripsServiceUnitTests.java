package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.mockito.Mockito.*;

public class TripsServiceUnitTests {

    @Test
    public void shouldNotAllowToLookForTripsForAUserWhenNoUserIsLoggedIn() {
        UserSession userSession = mock(UserSession.class);

        try(MockedStatic<UserSession> mockedStatic = mockStatic(UserSession.class)){
            mockedStatic.when(UserSession::getInstance).thenReturn(userSession);
            when(userSession.getLoggedUser()).thenReturn(null);
            TripService tripService = new TripService();
            assertThrows(UserNotLoggedInException.class,() -> tripService.getTripFor(null));
        }
    }

    @Test
    public void shouldReturnTripsWhenUserIsAFriendOfLoggedInUser() {
        UserSession userSession = mock(UserSession.class);
        User loggedInUser = new User();
        User loggedInUserFriend = new User();
        loggedInUserFriend.addFriend(loggedInUser);
        try(MockedStatic<UserSession> userSessionStaticMock = mockStatic(UserSession.class);
            MockedStatic<TripDAO> tripDaoStaticMock = mockStatic(TripDAO.class);){

            userSessionStaticMock.when(() -> UserSession.getInstance()).thenReturn(userSession);
            when(userSession.getLoggedUser()).thenReturn(loggedInUser);
            List<Trip> trips = new ArrayList<>(Arrays.asList(new Trip()));

            tripDaoStaticMock.when(()->TripDAO.findTripsByUser(any())).thenReturn(trips);

            TripService tripService = new TripService();
            List<Trip> userTrips = tripService.getTripFor(loggedInUserFriend);
            assertEquals(1,userTrips.size());
        }
    }

    @Test
    public void shouldNotReturnTripsWhenUserIsNotAFriendOfLoggedInUser(){
        UserSession userSession = mock(UserSession.class);
        User loggedInUser = new User();
        User userNotAFriendOfLoggedInUser = new User();
        try(MockedStatic<UserSession> userSessionStaticMock = mockStatic(UserSession.class);){
            userSessionStaticMock.when(UserSession::getInstance).thenReturn(userSession);
            when(userSession.getLoggedUser()).thenReturn(loggedInUser);
            TripService tripsService = new TripService();
            List<Trip> trips = tripsService.getTripFor(userNotAFriendOfLoggedInUser);
            assertEquals(0,trips.size());
        }
    }
}
