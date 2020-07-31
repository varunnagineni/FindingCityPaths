package com.mc.find.city.paths.contoller;

import com.mc.find.city.paths.delegator.PathFinder;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindCityPathsController {
    private static final Logger log = LoggerFactory.getLogger(FindCityPathsController.class);

    private final PathFinder pathFinder;

    public FindCityPathsController(@Autowired PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public String findIfRouteAvailable (@RequestParam(value = "origin") String origin,
                                         @RequestParam(value = "destination") String destination) {

        try {
            log.info("Origin : {} , Destination : {} ", origin, destination);
            return pathFinder.findPath(origin, destination);
        } catch (Exception ex) {
            log.error("Exception while finding the Path between Origin = {}" +
                    ", and Destination = {}, Exception = {}", origin, destination, ex.getMessage());
            return "NO";
        }
    }
}
