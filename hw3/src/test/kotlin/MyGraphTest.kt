import org.example.MyGraph
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyGraphTest {
    @Test
    fun getVertices() {
        val graph = createGraph()
        assertEquals(setOf("S", "A", "B", "C", "D", "E", "H", "F", "G"), graph.getVertices())
    }

    @Test
    fun getEdges() {
        val graph = createGraph()
        assertEquals(mapOf("H" to 1.0, "F" to 2.0), graph.getEdges("E"))
    }

    @Test
    fun addEdge() {
        val graph = createGraph()
        graph.addEdge("D", "Q", 4.0)
        assertEquals(setOf("S", "A", "B", "C", "D", "E", "H", "F", "G", "Q"), graph.getVertices())
        assertEquals(mapOf("G" to 5.0, "Q" to 4.0), graph.getEdges("D"))
    }

    @Test
    fun clear() {
        val graph = createGraph()
        graph.clear()
        assertEquals(setOf<String>(), graph.getVertices())
    }

    @Test
    fun dijkstras() {
        val graph = createGraph()
        assertEquals(listOf("S", "A"), graph.dijkstras("S", "A"))
        assertEquals(listOf("S", "C", "D"), graph.dijkstras("S", "D"))
        assertEquals(null, graph.dijkstras("H", "D"))
        assertEquals(listOf("S", "A", "E", "H", "G"), graph.dijkstras("S", "G"))
    }

    fun createGraph(): MyGraph<String> {
        val graph = MyGraph<String>()
        graph.addEdge("S", "A", 2.0)
        graph.addEdge("S", "B", 1.0)
        graph.addEdge("S", "C", 2.0)
        graph.addEdge("A", "E", 1.0)
        graph.addEdge("B", "D", 3.0)
        graph.addEdge("C", "D", 1.0)
        graph.addEdge("D", "G", 5.0)
        graph.addEdge("E", "H", 1.0)
        graph.addEdge("E", "F", 2.0)
        graph.addEdge("H", "G", 1.0)
        return graph
    }
}