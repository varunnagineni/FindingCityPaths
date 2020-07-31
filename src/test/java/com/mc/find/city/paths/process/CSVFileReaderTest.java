package com.mc.find.city.paths.process;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVFileReaderTest {

    @Test
    public void whenFileFoundReturnList() throws IOException {

        String FILE_PATH = "src/test/resources/Routes.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
        assertEquals(rawList.size(), 11);
    }

    @Test(expected = IOException.class)
    public void whenFileNotFoundReturnException() throws IOException {

        String FILE_PATH = "src/test/resources/Route.txt";
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> rawList = new ArrayList<>();

        csvFileReader.getListOfPaths(rawList, FILE_PATH);
    }
}
