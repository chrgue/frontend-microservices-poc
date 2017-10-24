package com.chrgue.poc.spiderman;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class Util {

    static public void addToResponse(HttpServletRequest request, HttpServletResponse response) {

        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromRequest(request);
        String cssString = Stream.of("/spiderman/spiderman.css")
                .map(s -> String.format("<%s>; rel='stylesheet'", builder.replacePath(s).build().toUriString()))
                .collect(Collectors.joining(", "));

        String jsString = Stream.of("/spiderman/spiderman.js")
                .map(s -> String.format("<%s>; rel='fragment-script'", builder.replacePath(s).build().toUriString()))
                .collect(Collectors.joining(", "));

        response.addHeader("Link", jsString + ", " + cssString);
    }
}
