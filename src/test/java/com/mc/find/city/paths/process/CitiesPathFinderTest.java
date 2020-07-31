package com.mc.find.city.paths.process;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CitiesPathFinderTest {

    @Test
    public void ifPathAvailableThenReturnYes() throws IOException {

        String FILE_PATH = "src/test/resources/Routes.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
        assertEquals(rawList.size(), 11);

        CitiesPathFinder citiesPathFinder = new CitiesPathFinder();
        assertEquals(citiesPathFinder.isPathAvailable("Boston", "Austin", rawList), "YES");
    }

    @Test
    public void ifPathNotAvailableThenReturnNo() throws IOException {

        String FILE_PATH = "src/test/resources/Routes.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
        assertEquals(rawList.size(), 11);

        CitiesPathFinder citiesPathFinder = new CitiesPathFinder();
        assertEquals(citiesPathFinder.isPathAvailable("Boston", "Queens", rawList), "NO");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenEmptyRowsFoundInAFileThenThrowException() throws IOException {

        String FILE_PATH = "src/test/resources/Routes.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();
        rawList.add("");

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
        assertEquals(rawList.size(), 12);

        CitiesPathFinder citiesPathFinder = new CitiesPathFinder();
        citiesPathFinder.isPathAvailable("Boston", "Queens", rawList);
    }

    @Test
    public void ifEmptyFileThenReturnNo() throws IOException {

        String FILE_PATH = "src/test/resources/EmptyFile.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
        assertEquals(rawList.size(), 0);

        CitiesPathFinder citiesPathFinder = new CitiesPathFinder();
        assertEquals(citiesPathFinder.isPathAvailable("Boston", "Queens", rawList), "NO");
    }
}
