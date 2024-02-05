package com.amindev.gatewayservice.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints;

    static {
        openApiEndpoints = new ArrayList<>();
        openApiEndpoints.add("/auth/register");
        openApiEndpoints.add("/auth");
        openApiEndpoints.add("/eureka");
    }

    public static final Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
