package ru.netology.wall

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import ru.netology.post.*
import ru.netology.post.attachment.Graffiti
import ru.netology.post.attachment.Note

internal class WallServiceTest {
    lateinit var wallService: WallService

    @BeforeEach
    fun setUp() {
        wallService = WallService(arrayOf())
    }

    @Test
    fun addShouldNotReturn0id() {
        wallService.add(
            Post(
                121,
                11,
                34,
                33,
                1000,
                "Привет",
                22,
                33,
                true,
                Comments(44, true, true, true, true),
                Copyright(77, "Пока", "оатмот", "акомтко"),
                Likes(12, 23, 34, 45),
                Reposts(12, 23),
                Views(33),
                "post",
                PostSource("амцам", "ошатмоцутам", "ошутмутм", "втутцамт"),
                arrayOf(Graffiti(22, 34, "ыашмо", "атмоуат")),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                arrayOf(Reposts(55, 77)),
                true,
                true,
                true,
                true,
                true,
                true,
                Donut(true, 34, true, Placeholder("овтпит"), "армрг"),
                12
            )
        )
        assertEquals(1, wallService.getId())
    }

    @Test
    fun updateExictingPost() {
        wallService.add(
            Post(
                121,
                11,
                34,
                33,
                1000,
                "Привет",
                22,
                33,
                true,
                Comments(44, true, true, true, true),
                Copyright(77, "Пока", "оатмот", "акомтко"),
                Likes(12, 23, 34, 45),
                Reposts(12, 23),
                Views(33),
                "post",
                PostSource("амцам", "ошатмоцутам", "ошутмутм", "втутцамт"),
                arrayOf(Graffiti(22, 34, "ыашмо", "атмоуат")),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                arrayOf(Reposts(55, 77)),
                true,
                true,
                true,
                true,
                true,
                true,
                Donut(true, 34, true, Placeholder("овтпит"), "армрг"),
                12
            )
        )

        val result = wallService.update(
            Post(
                0,
                11,
                34,
                33,
                1000,
                "РАКЕТА",
                22,
                33,
                true,
                Comments(44, true, true, true, true),
                Copyright(77, "Пока", "оатмот", "акомтко"),
                Likes(12, 23, 34, 45),
                Reposts(12, 23),
                Views(33),
                "post",
                PostSource("амцам", "ошатмоцутам", "ошутмутм", "втутцамт"),
                arrayOf(Graffiti(22, 34, "ыашмо", "атмоуат")),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                arrayOf(Reposts(55, 77)),
                true,
                true,
                true,
                true,
                true,
                true,
                Donut(true, 34, true, Placeholder("овтпит"), "армрг"),
                12
            )
        )
        assertEquals("РАКЕТА", wallService.posts[0].text)
        assertTrue(result)
    }

    @Test
    fun updateNotExictingPost() {
        wallService.add(
            Post(
                121,
                11,
                34,
                33,
                1000,
                "Привет",
                22,
                33,
                true,
                Comments(44, true, true, true, true),
                Copyright(77, "Пока", "оатмот", "акомтко"),
                Likes(12, 23, 34, 45),
                Reposts(12, 23),
                Views(33),
                "post",
                PostSource("амцам", "ошатмоцутам", "ошутмутм", "втутцамт"),
                arrayOf(Graffiti(22, 34, "ыашмо", "атмоуат")),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                arrayOf(Reposts(55, 77)),
                true,
                true,
                true,
                true,
                true,
                true,
                Donut(true, 34, true, Placeholder("овтпит"), "армрг"),
                12
            )
        )

        val result = wallService.update(
            Post(
                121,
                11,
                34,
                33,
                1000,
                "РАКЕТА",
                22,
                33,
                true,
                Comments(44, true, true, true, true),
                Copyright(77, "Пока", "оатмот", "акомтко"),
                Likes(12, 23, 34, 45),
                Reposts(12, 23),
                Views(33),
                "post",
                PostSource("амцам", "ошатмоцутам", "ошутмутм", "втутцамт"),
                arrayOf(Graffiti(22, 34, "ыашмо", "атмоуат")),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                arrayOf(Reposts(55, 77)),
                true,
                true,
                true,
                true,
                true,
                true,
                Donut(true, 34, true, Placeholder("овтпит"), "армрг"),
                12
            )
        )
        assertFalse(result)
    }
}