package org.example

class MyLinkedList<T>: LinkedList<T>{

    class Node<T> (var data: T, var next:Node<T>?, var prev:Node<T>?)

    var first: Node<T>? = null
    var last: Node<T>? = null

    override fun pushFront(data: T) {
        val newNode = Node<T>(data, first, null)
        first?.prev = newNode
        first = newNode
    }

    override fun pushBack(data: T) {
        val newNode = Node<T>(data, null, last)
        last?.next = newNode
        last = newNode
    }

    override fun popFront(): T? {
        val data = first?.data
        first = first?.next
        first?.prev = null
        return data
    }

    override fun popBack(): T? {
        val data = last?.data
        last = last?.prev
        last?.next = null
        return data
    }

    override fun peekFront(): T? {
        return first?.data
    }

    override fun peekBack(): T? {
        return last?.data
    }

    override fun isEmpty(): Boolean {
        return (first != null)
    }
}

interface LinkedList<T> {
    /**
     * Adds the element [data] to the front of the linked list.
     */
    fun pushFront(data: T)

    /**
     * Adds the element [data] to the back of the linked list.
     */
    fun pushBack(data: T)

    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T?

    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T?

    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront(): T?

    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack(): T?

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean
}
