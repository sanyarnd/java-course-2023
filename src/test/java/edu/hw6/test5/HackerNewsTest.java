package edu.hw6.test5;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HackerNewsTest {
    @ParameterizedTest
    @MethodSource("dataForHackerNews")
    public void hackerNewsTopStories_successTest(long id, String title) {
        HackerNews hackerNews = new HackerNews();

        String newsTitle = hackerNews.news(id);

        assertThat(newsTitle).isEqualTo(title);
    }

    private static Stream<Arguments> dataForHackerNews() {
        return Stream.of(
            Arguments.of(38394736, "Microsoft Gives Up on ThreadX/Azure RTOS and Releases It as Open Source"),
            Arguments.of(38420042, "Pipewire 1.0.0"),
            Arguments.of(38404905, "The Ambassador Pattern")
        );
    }
}
