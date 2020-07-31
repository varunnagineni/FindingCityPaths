package com.mc.find.city.paths.delegator;

import com.mc.find.city.paths.process.PathFinderService;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PathFinderTest {

    @Test(expected = RuntimeException.class)
    public void whenOriginIsNullThenReturnNo() throws IOException {

        PathFinderService pathFinderService = mock(PathFinderService.class);
        PathFinder pathFinder = new PathFinder(pathFinderService);

        pathFinder.findPath("", "someDestination");
    }

    @Test(expected = RuntimeException.class)
    public void whenDestinationIsNullThenReturnNo() throws IOException {

        PathFinderService pathFinderService = mock(PathFinderService.class);
        PathFinder pathFinder = new PathFinder(pathFinderService);

        pathFinder.findPath("someOrigin", "");
    }

    @Test
    public void whenPathIsAvailableThenReturnYes() throws IOException {

        PathFinderService pathFinderService = mock(PathFinderService.class);
        when(pathFinderService.processCitiesForPaths(anyString(), anyString())).thenReturn("YES");
        PathFinder pathFinder = new PathFinder(pathFinderService);

        assertEquals(pathFinder.findPath("someOrigin", "someDestination"), "YES");
    }

    @Test
    public void whenPathIsNotAvailableThenReturnNo() throws IOException {

        PathFinderService pathFinderService = mock(PathFinderService.class);
        when(pathFinderService.processCitiesForPaths(anyString(), anyString())).thenReturn("NO");
        PathFinder pathFinder = new PathFinder(pathFinderService);

        assertEquals(pathFinder.findPath("someOrigin", "someDestination"), "NO");
    }
}
