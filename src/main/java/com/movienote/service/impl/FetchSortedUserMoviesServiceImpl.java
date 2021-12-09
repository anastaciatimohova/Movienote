package com.movienote.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movienote.dto.MovieDto;
import com.movienote.exception.MovienoteServiceException;
import com.movienote.service.FetchSortedUserMoviesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FetchSortedUserMoviesServiceImpl implements FetchSortedUserMoviesService {

    private static final String JSON_NODE_STR = "results";
    private static final String API_KEY = "api_key";
    private static final String QUERY = "query";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${tmdb.apikey}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String host;

    @Value("${tmdb.api.path.fetch-sorted-movie-by-title}")
    private String fetchSortedMovieByTitle;

    @Value("${tmdb.api.path.fetch-sorted-movie-by-rating}")
    private String fetchSortedMovieByRating;

    @Value("${tmdb.api.path.fetch-sorted-movie-by-status}")
    private String fetchSortedMovieByStatus;

    @Value("${tmdb.api.path.fetch-sorted-movie-by-created}")
    private String fetchSortedMovieByCreated;


    public List<MovieDto> fetchSortedMovieByTitle(MovieDto dto) {
        URI uri = createFromPathURI(fetchSortedMovieByTitle)
                .queryParam(QUERY, dto.getQuery())
                .build()
                .toUri();
        return getMovieFromTMDB(uri);
    }


    public List<MovieDto> fetchSortedMovieRating(MovieDto dto) {
        URI uri = createFromPathURI(fetchSortedMovieByRating)
                .build()
                .toUri();
        return getMovieFromTMDB(uri);
    }


    public List<MovieDto> fetchSortedMovieStatus(MovieDto dto) {
        URI uri = createFromPathURI(fetchSortedMovieByStatus)
                .build()
                .toUri();
        return getMovieFromTMDB(uri);
    }


    public MovieDto fetchSortedMovieCreated(MovieDto dto) {
        URI uri = createFromPathURI(fetchSortedMovieByCreated)
                .build()
                .toUri();
        try {

            RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String moviesJson = response.getBody();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            return objectMapper.readValue(moviesJson, MovieDto.class);

        } catch (Exception e) {

            log.error(String.format("Movie not found from TheMovieDB. %s", e.getMessage()));

            throw new MovienoteServiceException("Movie not found from TheMovieDB");
        }
    }

    private List<MovieDto> getMovieFromTMDB(URI uri) {
        try {

            RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode responseBody = objectMapper.readTree(response.getBody());
            JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);

            return objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
            });

        } catch (Exception e) {

            log.error(String.format("Movie not found from TheMovieDB. %s", e.getMessage()));

            throw new MovienoteServiceException("Movie not found from TheMovieDB");
        }
    }

    private UriComponentsBuilder createFromPathURI(String path) {
        return UriComponentsBuilder
                .newInstance()
                .host(host)
                .path(path)
                .queryParam(API_KEY, apiKey);
    }
}
