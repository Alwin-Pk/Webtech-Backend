/*
package de.htw.backend;

import de.htw.backend.persistence.GuestRepository;
import de.htw.backend.service.GuestService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BackendServiceTest implements WithAssertions
{
    @Mock
    private GuestRepository repo;

    @InjectMocks
    private GuestService serviceTest;

    @Test
    @DisplayName("Should return true if delete of given Id was successful.")
    void trueIfDeleteSucceeds()
    {
        Long testId = 1337L;
        boolean result = serviceTest.deleteById(testId);

        doReturn(true).when(repo).existsById(testId);

        verify(repo).deleteById(testId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return false if given Id does not exist.")
    void falseIfIdDoesNotExist()
    {
        Long testId = 1337L;
        boolean result = serviceTest.deleteById(testId);

        doReturn(false).when(repo).existsById(testId);

        verifyNoMoreInteractions(repo);
        assertThat(result).isFalse();
    }
}
*/
