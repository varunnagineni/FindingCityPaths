package com.mc.find.city.paths.delegator;

import com.mc.find.city.paths.process.PathFinderService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PathFinder {

    private final PathFinderService pathFinderService;

    public PathFinder(@Autowired PathFinderService pathFinderService) {
        this.pathFinderService = pathFinderService;
    }

    public String findPath(String origin, String destination) throws IOException {

        if (StringUtils.isBlank(origin.trim()) || StringUtils.isEmpty(destination.trim())) {
            throw new RuntimeException("Input data is not valid");
        }

        //Call the business class
        return pathFinderService.processCitiesForPaths(origin, destination);
    }
}
