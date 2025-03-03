package ru.netology

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val lastPost = WallService.add(Post(text = "Привет! Тест"))
        val (result) = lastPost
        assertEquals(1, result)
    }

    @Test
    fun updateExistingId() {
        WallService.add(Post(text = "Привет! Тест1"))
        WallService.add(Post(text = "Привет! Тест2"))

        val result = WallService.update(Post(1, text = "Обновление текста"))
        assertEquals(true, result)
    }

    @Test
    fun updateUnExistingId() {
        WallService.add(Post(text = "Привет! Тест1"))
        WallService.add(Post(text = "Привет! Тест2"))

        val result = WallService.update(Post(2, text = "Обновление текста"))
        assertEquals(false, result)
    }

}