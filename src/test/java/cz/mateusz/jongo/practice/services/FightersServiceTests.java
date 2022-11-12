package cz.mateusz.jongo.practice.services;

import cz.mateusz.jongo.practice.database.collections.FightersCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FightersServiceTests {

    @Mock
    private FightersCollection fightersCollection;

    @InjectMocks
    private MainFightersService fightersService;

    @Test
    public void shouldRegisterFighter() {}
}
