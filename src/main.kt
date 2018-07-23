package dsa

import java.util.*

fun main(args: Array<String>) {
    val list : Array<Int> = arrayOf(4, 9, 7 ,1 ,3, 6,5)
    println(list.size)
    bubbleSort(list)
    println(Arrays.toString(list))
    linearSearch(list, 5)
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
    var swapped = true;

    do {
        swapped = false
        for(i in 0 until n - 1){
            println("i is $i, comparing " + list[i] + " and " + list[i+1])
            if(list[i] > list[i+1]){
                println(Arrays.toString(list))
                var temp: Int = list[i]
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