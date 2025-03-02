package ru.netology
import org.junit.Test
import org.junit.Assert.*

 class WallServiceTest {

@Test
 fun add() {
  val lastPost = WallService.add(Post(text = "Привет! Тест"))
  val (result) = lastPost
  assertEquals(1, result)
 }

}