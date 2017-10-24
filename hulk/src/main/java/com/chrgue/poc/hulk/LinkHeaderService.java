package com.chrgue.poc.hulk;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LinkHeaderService {

    @Value("${spring.application.name}")
    private String appName;

    public void addToResponse(HttpServletRequest request, HttpServletResponse response) {

        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromRequest(request);

        String cssString = Stream.of("/"+ appName + "/hulk.css")
                .map(s -> String.format("<%s>; rel='stylesheet'", builder.replacePath(s).build().toUriString()))
                .collect(Collectors.joining(", "));

        String jsString = Stream.of("/" + appName + "/hulk.js")
                .map(s -> String.format("<%s>; rel='fragment-script'", builder.replacePath(s).build().toUriString()))
                .collect(Collectors.joining(", "));

        response.addHeader("Link", jsString + ", " + cssString);
    }
}
