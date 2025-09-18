import org.example.MyLinkedList
import org.example.MyStack
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyStackTest {
    @Test
    fun pushPopEmpty() {
        val stack = MyStack<Int>()
        stack.push(5)
        assertFalse(stack.isEmpty())
        assertEquals(5, stack.peek())
        assertEquals(5, stack.pop())
        assertTrue(stack.isEmpty())
    }
}