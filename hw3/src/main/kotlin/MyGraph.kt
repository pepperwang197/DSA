package org.example

import jdk.internal.jshell.tool.resources.version
import java.awt.geom.NoninvertibleTransformException
import java.beans.VetoableChangeListener
import java.nio.file.Path

class MyGraph<VertexType>: Graph<VertexType> {

    var vertexList: MutableSet<VertexType> = mutableSetOf()
    var edges: MutableMap<VertexType, MutableList<Pair<VertexType, Double>>> = mutableMapOf()

    override fun getVertices(): MutableSet<VertexType> {
        return vertexList
    }

    override fun addEdge(from: VertexType, to: VertexType, cost: Double) {
        if (edges.containsKey(from)){
            edges[from]!!.add(Pair(to, cost))
        } else{
            edges[from] = mutableListOf(Pair(to, cost))
        }

        vertexList.add(from)
        vertexList.add(to)
    }

    override fun getEdges(from: VertexType): Map<VertexType, Double> {
        if(edges.containsKey(from)){
            return edges[from]!!.toMap()
        }
        return mapOf()
    }

    override fun clear() {
        vertexList = mutableSetOf()
        edges = mutableMapOf()
    }

    fun dijkstras(start: VertexType, target: VertexType): List<VertexType>{
        var toVisit = PriorityQueue<PathType<VertexType>>()
        var visited: MutableMap<VertexType, PathType<VertexType>> = mutableMapOf()
        var currentPath = PathType<VertexType>(start, mutableListOf(), 0.0)
        while(true){
            if(currentPath.vertex == target){
                break
            }
            if (!edges.containsKey(currentPath.vertex)){ // current vertex has no paths going from it
                visited[currentPath.vertex] = PathType<VertexType>(currentPath.vertex, currentPath.path, currentPath.totalCost)
                if(toVisit.isEmpty()){
                    break
                }
                continue
            }
            var myEdges = edges[currentPath.vertex]!!.toList()
            for((nextVertex, cost) in myEdges){
                val newPath = currentPath.path.plus(nextVertex).toMutableList()
                toVisit.addWithPriority(PathType<VertexType>(nextVertex, newPath, currentPath.totalCost), currentPath.totalCost+cost)
            }
            visited[currentPath.vertex] = currentPath
            val next = toVisit.next()!!
            currentPath = next
        }
        return visited[target]!!.path
    }

    class PathType<T>(var vertex: T, var path: MutableList<T>, var totalCost: Double) {}
}

/**
 * ``Graph`` represents a directed graph
 * @param VertexType the type that represents a vertex in the graph
 */
interface Graph<VertexType> {
    /**
     * @return the vertices in the graph
     */
    fun getVertices(): Set<VertexType>

    /**
     * Add an edge between [from] and [to] with edge weight [cost]
     */
    fun addEdge(from: VertexType, to: VertexType, cost: Double)

    /**
     * Get all the edges that begin at [from]
     * @return a map where each key represents a vertex connected to [from] and the value represents the edge weight.
     */
    fun getEdges(from: VertexType): Map<VertexType, Double>

    /**
     * Remove all edges and vertices from the graph
     */
    fun clear()
}
