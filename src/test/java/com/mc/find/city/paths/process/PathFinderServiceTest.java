package com.mc.find.city.paths.process;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class PathFinderServiceTest {

    @Test
    public void whenPathIsAvailableThenReturnYes()  throws IOException {

        CSVFileReader csvFileReader = mock(CSVFileReader.class);
        CitiesPathFinder citiesPathFinder = mock(CitiesPathFinder.class);
        doNothing().when(csvFileReader).getListOfPaths(anyList(), anyString());
        when(citiesPathFinder.isPathAvailable(anyString(), anyString(), anyList())).thenReturn("YES");
        PathFinderService pathFinderService = new PathFinderService(csvFileReader, citiesPathFinder);

        assertEquals(pathFinderService.processCitiesForPaths(anyString(), anyString()), "YES");

    }
}
