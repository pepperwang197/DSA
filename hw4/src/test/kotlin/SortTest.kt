import org.example.selectionSort
import org.example.mergeSort
import org.example.insertionSort
import org.example.radixSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortTest {
    @Test
    fun selectionSortTest() {
        assertEquals(selectionSort(mutableListOf(3, 4, 2, 1, 5)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(selectionSort(mutableListOf(1, 2, 2, 1, 2)), mutableListOf(1, 1, 2, 2, 2))
        assertEquals(selectionSort(mutableListOf(5, 4, 3, 2, 1)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(selectionSort(mutableListOf(762, 926, 17, 219, 599, 456, 118)), mutableListOf(17, 118, 219, 456, 599, 762, 926))
        assertEquals(selectionSort(mutableListOf()), mutableListOf<Int>())
    }


    @Test
    fun mergeSortTest() {
        assertEquals(mergeSort(mutableListOf(3, 4, 2, 1, 5)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(mergeSort(mutableListOf(1, 2, 2, 1, 2)), mutableListOf(1, 1, 2, 2, 2))
        assertEquals(mergeSort(mutableListOf(5, 4, 3, 2, 1)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(mergeSort(mutableListOf(762, 926, 17, 219, 599, 456, 118)), mutableListOf(17, 118, 219, 456, 599, 762, 926))
        assertEquals(mergeSort(mutableListOf()), mutableListOf<Int>())
    }

    @Test
    fun insertionSortTest() {
        assertEquals(insertionSort(mutableListOf(3, 4, 2, 1, 5)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(insertionSort(mutableListOf(1, 2, 2, 1, 2)), mutableListOf(1, 1, 2, 2, 2))
        assertEquals(insertionSort(mutableListOf(5, 4, 3, 2, 1)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(insertionSort(mutableListOf(762, 926, 17, 219, 599, 456, 118)), mutableListOf(17, 118, 219, 456, 599, 762, 926))
        assertEquals(insertionSort(mutableListOf()), mutableListOf<Int>())
    }

    @Test
    fun radixSortTest() {
        assertEquals(radixSort(mutableListOf(3, 4, 2, 1, 5)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(radixSort(mutableListOf(1, 2, 2, 1, 2)), mutableListOf(1, 1, 2, 2, 2))
        assertEquals(radixSort(mutableListOf(5, 4, 3, 2, 1)), mutableListOf(1, 2, 3, 4, 5))
        assertEquals(radixSort(mutableListOf(762, 926, 17, 219, 599, 456, 118)), mutableListOf(17, 118, 219, 456, 599, 762, 926))
        assertEquals(radixSort(mutableListOf()), mutableListOf<Int>())
    }

}