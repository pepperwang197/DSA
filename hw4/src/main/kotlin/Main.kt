package org.example

import kotlin.math.pow
import kotlin.time.measureTime
import kotlin.time.DurationUnit
import kotlin.random.Random

fun selectionSort(inputList: MutableList<Int>): MutableList<Int> {
    if(inputList.isEmpty()){
        return inputList
    }

    val sortedList = mutableListOf<Int>()

    while(inputList.isNotEmpty()){
        var minValue = inputList[0]
        var minIndex = 0
        for((index, element) in inputList.withIndex()){
            if (element<minValue){
                minValue = element
                minIndex = index
            }
        }
        inputList.removeAt(minIndex)
        sortedList.add(minValue)
    }

    return sortedList
}

fun mergeSort(inputList: MutableList<Int>): MutableList<Int> {

    if(inputList.size<=1){
        return inputList
    }

    val list1 = inputList.slice(0..<inputList.size/2).toMutableList()
    val list2 = inputList.slice(inputList.size/2..inputList.lastIndex).toMutableList()

    val sortedList1 = mergeSort(list1)
    val sortedList2 = mergeSort(list2)

    if(sortedList1.isEmpty() || sortedList2.isEmpty()){
        return (sortedList1 + sortedList2).toMutableList()
    }

    var mergedList = mutableListOf<Int>()

    var pointer1 = 0
    var pointer2 = 0

    while(mergedList.size != inputList.size){

        // if pointer1 reaches the end of list1, use the rest of list 2 and break
        if (pointer1 > sortedList1.lastIndex){
            mergedList = (mergedList+sortedList2.slice(pointer2..sortedList2.lastIndex)).toMutableList()
            break
        }
        // if pointer2 reaches the end of list2, use the rest of list 1 and break
        if(pointer2 > sortedList2.lastIndex){
            mergedList = (mergedList+sortedList1.slice(pointer1..sortedList1.lastIndex)).toMutableList()
            break
        }

        // compare values from both lists, add the smaller one to the merged list
        val val1 = sortedList1[pointer1]
        val val2 = sortedList2[pointer2]
        if(val1>val2){
            mergedList.add(val2)
            pointer2++
        } else if(val1<val2){
            mergedList.add(val1)
            pointer1++
        } else {
            mergedList.add(val1)
            mergedList.add(val2)
            pointer1++
            pointer2++
        }
    }

    return mergedList
}

fun insertionSort(inputList: MutableList<Int>): MutableList<Int> {
    for (i in 1..inputList.lastIndex){
        val element = inputList[i]
        var j = i-1
        while(j>=0){
            if (inputList[j] <= element){
                break
            }
            j--
        }
        inputList.removeAt(i)
        inputList.add(j+1, element)
    }
    return inputList
}

fun radixSort(inputList: MutableList<Int>): MutableList<Int> {
    var inputList = inputList
    var digit = 0
    while(true){
        val buckets = MutableList(10) { MutableList<Int>(0) {0} }
        for (element in inputList){
            var elementDigit = 0
            if(element >= 10.0.pow(digit)){
                // elementDigit = element.toString()[element.toString().lastIndex-digit].digitToInt()
                elementDigit = ((element % (10.0.pow(digit+1).toInt()))).toString()[0].digitToInt()
            }
            buckets[elementDigit].add(element)
        }
        inputList = buckets.flatten().toMutableList()
        if(buckets[0].size == inputList.size){
            break
        }
        digit++
    }
    return inputList
}

fun testSortingAlgorithm(name:String, alg: (MutableList<Int>) -> MutableList<Int>){
    val samples = 3

    val averagedRunTimes = mutableListOf<Double>()
    for (size in listOf(10, 100, 1000, 10000, 100000)) {
        var runTimes = 0.0
        for (i in (0..samples)){
            val x = (1 until size).map { Random.nextInt(100000) }
            val runTime = measureTime {
                alg(x.toMutableList())
            }
            runTimes += runTime.toDouble(DurationUnit.SECONDS)
        }
        averagedRunTimes.add(runTimes/samples)
    }
    println("$name sort runtimes are $averagedRunTimes")
}

fun main() {
    testSortingAlgorithm("Selection", ::selectionSort)
    testSortingAlgorithm("Merge", ::mergeSort)
    testSortingAlgorithm("Insertion", ::insertionSort)
    testSortingAlgorithm("Radix", ::radixSort)
}