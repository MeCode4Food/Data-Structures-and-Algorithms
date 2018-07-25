package dsa

import java.util.*

fun main(args: Array<String>) {
    var list : Array<Int> = arrayOf(4, 9, 7 ,1 ,3, 6,5)
    println(list.size)
    list = mergeSort(list)
    println(Arrays.toString(list))
    linearSearch(list, 5)
}


fun mergeSort(list: Array<Int>): Array<Int>{

    fun mergeArrays(left: Array<Int>, right: Array<Int>): Array<Int>{
        var i = 0
        var j = 0
        var index = 0
        var result: Array<Int> = Array(left.size + right.size,{_ -> 0})

        while(i < left.size && j < right.size){
            println("left: " + left[i] + " right: " + right[j])
            println("i: $i, j: $j")
            if(left[i] < right[j]){
                result[index++] = left[i++]
            }
            else{
                result[index++] = right[j++]
            }
            println("currently at " +  Arrays.toString(result))
        }

        while(i < left.size){
            result[index++] = left[i++]
            println("currently at " +  Arrays.toString(result))
        }

        while(j < right.size){
            result[index++] = right[j++]
            println("currently at " +  Arrays.toString(result))
        }

        return result
    }
    val n: Int = list.size

    if(n <= 1){
        println("returning " + Arrays.toString(list))
        return list
    }
    var left: Array<Int>
    var right: Array<Int>

    left = list.sliceArray(0 until n/2)
    right = list.sliceArray((n/2) until n)
    println("left " + Arrays.toString(left) + " right " + Arrays.toString(right))

    left = mergeSort(left)
    right = mergeSort(right)

    return mergeArrays(left, right)
}

fun selectionSort(list: Array<Int>){
    for (i in 0 until list.size){
        for(j in  i+1 until list.size){
            if(list[i] > list[j]){
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }
    }
}

fun bubbleSort(list: Array<Int>){
    val n: Int = list.size
    var swapped: Boolean

    do {
        swapped = false
        for(i in 0 until n - 1){
            println("i is $i, comparing " + list[i] + " and " + list[i+1])
            if(list[i] > list[i+1]){
                println(Arrays.toString(list))
                val temp: Int = list[i]
                list[i] = list[i + 1]
                list[i+ 1] = temp
                swapped = true
            }
        }
    }while(swapped)
}


fun linearSearch(list: Array<Int>, v: Int){
    val n: Int = list.size;
    for(i in 0 until n){
        if(list[i] == v){
            println("Found $v at position " + (i+1))
            return
        }
    }
    println("Element $v not found in array")
    return
}