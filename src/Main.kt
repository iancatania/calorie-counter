import java.io.File //imported java libraries
import java.util.Scanner

fun main() {

    var array = MutableList(5) { foodItem("", "", 0) } //foodItem array declaration
    array.clear()

    val scanner = Scanner(File("C:\\Users\\Ian Catania\\IdeaProjects\\Kotlin Basics\\src\\food.txt")) //scanner takes text file
    scanner.useDelimiter(",") //separates data by comma

    while (scanner.hasNext()) { //iterates through scanner data
        val name = scanner.next() //creates name string
        val type = scanner.next() //creates type string
        val calories = scanner.nextInt() //creates calories int
        var food = foodItem(name, type, calories) //initializes food obj with params from data

        array.add(foodItem(name, type, calories)) //adds obj to arrayList
    }

    var myCalories = 0 //creates calorie tracker int

    println("How many calories a day do you eat?") //user prompts
    myCalories = Integer.valueOf(readLine()) //reads user input as val of tracker int

    println("What meal of the day are you having?")
    var mealType = readLine() //creates meal type tracker as string input of prompt

    fun findFoodType(): Unit { //function to fetch data of matching food type
        var type = mealType

        for (i in array.indices) { //for loop to iterate list
            if (array.get(i).type == type.toString()) { //if type input matches food item type
                var newCalories = myCalories - array.get(i).calories //sets new calories to daily cal - food cal
                print(array.get(i).name + ", " + array.get(i).calories + " calories, you have " + newCalories + " daily calories left.")
                //prints the info of each food item using built in data class getters
            }
        }
    }

    println("Your options are: ")
    findFoodType() //method call
}

data class foodItem(val name: String, val type: String, val calories: Int) //data class declaration for foodItem

