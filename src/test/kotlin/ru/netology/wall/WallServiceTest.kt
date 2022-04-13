package ru.netology.wall

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import ru.netology.post.*
import ru.netology.post.attachment.Graffiti
import ru.netology.post.attachment.GraffitiAttachment
import ru.netology.post.attachment.Note
import ru.netology.post.comment.Comment
import ru.netology.post.comment.Thread

internal class WallServiceTest {
    lateinit var wallService: WallService

    @BeforeEach
    fun setUp() {
        wallService = WallService()
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
        assertEquals(1, wallService.getPost(0).id)
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
                1,
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
        assertEquals("РАКЕТА", wallService.getPost(0).text)
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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

    @Test
    fun shouldAddComment() {
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
        wallService.createComment(
            Comment(
                1,
                11,
                11,
                "амуа",
                1,
                ru.netology.post.comment.Donut(true, "амукц"),
                13,
                34,
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                mutableListOf(),
                ru.netology.post.comment.Thread(15, mutableListOf(), true, true, true)
            )
        )
        assertEquals("амуа", wallService.getComment(0).text)
    }

    @Test
    fun shouldReturnException() {
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
                mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                Geo("аотмоуашт", "32", Place(32, "тсту", 21, 23, 45, "шьшьш", 12, 11, 23, 34, 45, "рисриуа")),
                88,
                mutableListOf(Reposts(55, 77)),
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
        assertThrowsExactly(
            PostNotFoundException::class.java
        ) {
            wallService.createComment(
                Comment(
                    1,
                    11,
                    11,
                    "амуа",
                    12,
                    ru.netology.post.comment.Donut(true, "амукц"),
                    13,
                    34,
                    mutableListOf(GraffitiAttachment(graffiti = Graffiti(12, 23, "воатмо", "шоуатмошцут"))),
                    mutableListOf(),
                    ru.netology.post.comment.Thread(15, mutableListOf(), true, true, true)
                )
            )
        }
    }
}