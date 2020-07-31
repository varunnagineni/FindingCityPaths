package com.mc.find.city.paths.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PathFinderService {

    private static final Logger log = LoggerFactory.getLogger(PathFinderService.class);

    private static final String FILE_PATH = "src/main/resources/Routes.txt";
    private final CSVFileReader csvFileReader;
    private final CitiesPathFinder citiesPathFinder;

    public PathFinderService(@Autowired CSVFileReader csvFileReader, @Autowired CitiesPathFinder citiesPathFinder) {
        this.csvFileReader = csvFileReader;
        this.citiesPathFinder = citiesPathFinder;
    }

    public String processCitiesForPaths(String origin, String destination) throws IOException {

        List<String> rawData = new ArrayList<>();
        csvFileReader.getListOfPaths(rawData, FILE_PATH);

        return citiesPathFinder.isPathAvailable(origin, destination, rawData);
    }
}
