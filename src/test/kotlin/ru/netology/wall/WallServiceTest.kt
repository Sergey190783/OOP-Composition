package ru.netology.wall

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import ru.netology.post.*

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
                122,
                12,
                33,
                35,
                100,
                "Пока",
                21,
                33,
                false,
                Comments(12, false, true, true, false),
                Copyright(77, "GJN", "feve", "rvb"),
                Likes(11, 25, 37, 40),
                Reposts(11, 22),
                Views(31),
                "wec",
                55,
                false,
                false,
                true,
                true,
                true,
                true,
                Donut(true, 33, true, Placeholder("fvefbv"), "nbnbg"),
                11
            )
        )

        assertEquals(1, wallService.getId())
    }

    @Test
    fun updateExictingPost() {
        wallService.add(
            Post(
                122,
                12,
                33,
                35,
                100,
                "Пока",
                21,
                33,
                false,
                Comments(12, false, true, true, false),
                Copyright(77, "GJN", "feve", "rvb"),
                Likes(11, 25, 37, 40),
                Reposts(11, 22),
                Views(31),
                "wec",
                55,
                false,
                false,
                true,
                true,
                true,
                true,
                Donut(true, 33, true, Placeholder("fvefbv"), "nbnbg"),
                11
            )
        )

        val result = wallService.update(
            Post(
                0,
                12,
                33,
                35,
                100,
                "РАКЕТА",
                21,
                33,
                false,
                Comments(12, false, true, true, false),
                Copyright(77, "GJN", "feve", "rvb"),
                Likes(11, 25, 37, 40),
                Reposts(11, 22),
                Views(31),
                "wec",
                55,
                false,
                false,
                true,
                true,
                true,
                true,
                Donut(true, 33, true, Placeholder("fvefbv"), "nbnbg"),
                11
            )
        )
        assertEquals("РАКЕТА", wallService.posts[0].text)
        assertTrue(result)
    }

    @Test
    fun updateNotExictingPost() {
        wallService.add(
            Post(
                122,
                12,
                33,
                35,
                100,
                "Пока",
                21,
                33,
                false,
                Comments(12, false, true, true, false),
                Copyright(77, "GJN", "feve", "rvb"),
                Likes(11, 25, 37, 40),
                Reposts(11, 22),
                Views(31),
                "wec",
                55,
                false,
                false,
                true,
                true,
                true,
                true,
                Donut(true, 33, true, Placeholder("fvefbv"), "nbnbg"),
                11
            )
        )

        val result = wallService.update(
            Post(
                1,
                12,
                33,
                35,
                100,
                "РАКЕТА",
                21,
                33,
                false,
                Comments(12, false, true, true, false),
                Copyright(77, "GJN", "feve", "rvb"),
                Likes(11, 25, 37, 40),
                Reposts(11, 22),
                Views(31),
                "wec",
                55,
                false,
                false,
                true,
                true,
                true,
                true,
                Donut(true, 33, true, Placeholder("fvefbv"), "nbnbg"),
                11
            )
        )
        assertFalse(result)
    }
}