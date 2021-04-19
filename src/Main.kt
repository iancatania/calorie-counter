import java.io.File

import java.util.Scanner

fun main() {

    var array = MutableList(5) { foodItem("", "", 0) }
    array.clear()

    val scanner = Scanner(File("C:\\Users\\Ian Catania\\IdeaProjects\\Kotlin Basics\\src\\food.txt"))
    scanner.useDelimiter(",")

    while (scanner.hasNext()) {
        val name = scanner.next()
        val type = scanner.next()
        val calories = scanner.nextInt()
        var food = foodItem(name, type, calories)

        array.add(foodItem(name, type, calories))
    }

    var myCalories = 0

    println("How many calories a day do you eat?")
    myCalories = Integer.valueOf(readLine())

    println("What meal of the day are you having?")
    var mealType = readLine()
    
    fun findFoodType() {
        var type = mealType

        for (i in array.indices) {
            if (array.get(i).type == type.toString()) {
                var newCalories = myCalories - array.get(i).calories
                print(array.get(i).name + ", " + array.get(i).calories + " calories, you have " + newCalories + " daily calories left.")
            }
        }
    }

    println("Your options are: ")
    findFoodType()
}

data class foodItem(val name: String, val type: String, val calories: Int)

