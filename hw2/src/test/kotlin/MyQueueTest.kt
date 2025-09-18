import org.example.MyQueue
import org.example.MyStack
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyQueueTest {
    @Test
    fun enqueue() {
        val queue = MyQueue<Int>()
        queue.enqueue(5)
        assertFalse(queue.isEmpty())
        assertEquals(5, queue.peek())
        assertEquals(5, queue.dequeue())
        assertTrue(queue.isEmpty())
    }
}