package com.movienote.service;

import com.movienote.model.Genre;
import com.movienote.repository.GenreJpaRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {
    @Mock
    private GenreJpaRepository genreJpaRepository;
    @InjectMocks
    private GenreServiceImplementation genreService;

    @Test
    void deleteTest() {
        Genre genre = new Genre();
        genre.setId(2L);
        genreService.delete(genre.getId());
    }
}
