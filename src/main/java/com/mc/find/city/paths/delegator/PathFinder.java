package com.mc.find.city.paths.delegator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PathFinder {

    public boolean findPath(String origin, String destination) {

        if (StringUtils.isEmpty(origin) && StringUtils.isEmpty(destination)) {
            throw new RuntimeException("Input data is not valid");
        }

        //Call the business class
        return false;
    }
}
