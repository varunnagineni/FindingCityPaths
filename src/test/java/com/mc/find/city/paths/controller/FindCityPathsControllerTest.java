package com.mc.find.city.paths.controller;

import com.mc.find.city.paths.contoller.FindCityPathsController;
import com.mc.find.city.paths.delegator.PathFinder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindCityPathsControllerTest {

    @Test
    public void whenPathIsAvailableThenReturnYes() throws IOException {

        PathFinder pathFinder = mock(PathFinder.class);
        when(pathFinder.findPath(anyString(), anyString())).thenReturn("YES");
        FindCityPathsController findCityPathsController = new FindCityPathsController(pathFinder);

        assertEquals(findCityPathsController.findIfRouteAvailable("someOrigin", "someDestination"), "YES");
    }

    @Test
    public void whenPathIsNotAvailableThenReturnNo() throws IOException {

        PathFinder pathFinder = mock(PathFinder.class);
        when(pathFinder.findPath(anyString(), anyString())).thenReturn("NO");
        FindCityPathsController findCityPathsController = new FindCityPathsController(pathFinder);

        assertEquals(findCityPathsController.findIfRouteAvailable("someOrigin", "someDestination"), "NO");
    }

    @Test
    public void whenExceptionThenReturnNo() throws IOException {

        PathFinder pathFinder = mock(PathFinder.class);
        when(pathFinder.findPath(anyString(), anyString())).thenThrow(RuntimeException.class);
        FindCityPathsController findCityPathsController = new FindCityPathsController(pathFinder);

        assertEquals(findCityPathsController.findIfRouteAvailable("someOrigin", "someDestination"), "NO");
    }
}
