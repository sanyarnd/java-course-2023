package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

class SimpleTaskTrackerTest {

    private final HistoryViewManager<UUID> mockHistoryViewManager = Mockito.mock();
    private final SimpleTaskTracker simpleTaskTracker = new SimpleTaskTracker(mockHistoryViewManager);

    @Test
    void getViewHistory_shouldReturnTaskHistoryList() {
        // given
        Mockito.when(mockHistoryViewManager.getViewHistory())
            .thenReturn(List.of(UUID.randomUUID()));

        // when
        List<Task> taskHistory = simpleTaskTracker.getViewHistory();

        // then
        assertEquals(1, taskHistory.size());
    }
}
