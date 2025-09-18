package org.example
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var map: MutableList<String> = (File(System.getProperty("user.dir")+"\\src\\main\\kotlin\\test.txt").readLines()).toMutableList()

    for(line in map){
        println(line)
    }

    /*
    1: up
    2: right
    3: down
    4: left
    */
    
    var startingPoint: MutableList<Int> = mutableListOf()

    // find starting position and replace the ^ with a .
    for ((index, line) in map.withIndex()) {
        val startIndex = line.indexOf('^')
        if (startIndex != -1) {
            println("found line $line")
            startingPoint = mutableListOf(index, startIndex)
            break
        }
    }
    var currentRow = startingPoint[0]
    var currentCol = startingPoint[1]
    map[currentRow] = map[currentRow].replace('^', '.')

    println(map)
    println(startingPoint)

    var dir = 1
    var count = 0

    while (true) {
        var nextRow = currentRow
        var nextCol = currentCol
        when (dir) {
            1 -> nextRow--
            2 -> nextCol++
            3 -> nextRow++
            4 -> nextCol--
        }
        println("$nextRow, $nextCol")

        // reached edges of map
        if ((nextRow >= map.count()) or (nextRow < 0) or (nextCol >= map[0].count()) or (nextCol < 0)) {
            println("breaking")
            for(line in map){
                println(line)
            }
            break
        // found obstacle (change direction)
        } else if (map[nextRow][nextCol] == '#'){
            dir++
            if (dir == 5){
                dir = 1
            }
            println("change direction to $dir")
        // count spot (if not already counted)
        } else {
            if (map[nextRow][nextCol] != 'X') {
                count++
                map[nextRow] = map[nextRow].slice(0..<nextCol)+'X'+map[nextRow].slice((nextCol+1)..<map[nextRow].count())
            }
            currentRow = nextRow
            currentCol = nextCol
        }
    }
    println(count)
}