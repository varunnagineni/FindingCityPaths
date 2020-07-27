package com.mc.find.city.paths.contoller;

import com.mc.find.city.paths.delegator.PathFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindCityPathsController {
    private static final Logger log = LoggerFactory.getLogger(FindCityPathsController.class);

    private final PathFinder pathFinder;

    public FindCityPathsController(@Autowired PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @GetMapping("/connected")
    public Boolean findIfRouteAvailable (@RequestParam(value = "origin") String origin,
                                         @RequestParam(value = "destination") String destination) {
        log.info("Origin : {} , Destination : {} ", origin, destination);
        return pathFinder.findPath(origin, destination);
    }
}
