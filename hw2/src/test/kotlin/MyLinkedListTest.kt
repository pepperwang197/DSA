import org.example.MyLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyLinkedListTest {
    @Test
    fun pushFrontPeekEmpty() {
        val list = MyLinkedList<Int>()
        list.pushFront(5)
        assertFalse(list.isEmpty())
        assertEquals(5, list.peekFront())
        assertEquals(5, list.peekBack())
    }

    @Test
    fun pushBackPeekEmpty() {
        val list = MyLinkedList<Int>()
        list.pushBack(5)
        assertFalse(list.isEmpty())
        assertEquals(5, list.peekFront())
        assertEquals(5, list.peekBack())
    }

}