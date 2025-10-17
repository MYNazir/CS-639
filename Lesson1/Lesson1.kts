// Hello World function in Kotlin
fun printHello() {
    println("Hello World")
}

printHello()
// prints => Hello World

//basic Kotlin operations using the +, -, /, *
1+1
//⇒ res8: kotlin.Int = 2

53-3
//⇒ res9: kotlin.Int = 50

50/10
//⇒ res10: kotlin.Int = 5

1.0/2.0
//⇒ res11: kotlin.Double = 0.5

2.0*3.5
//⇒ res12: kotlin.Double = 7.0


//Note that results of operations keep the types of the operands, so 1/2 = 0, but 1.0/2.0 = 0.5.
6*50
//⇒ res13: kotlin.Int = 300

6.0*50.0
//⇒ res14: kotlin.Double = 300.0

6.0*50
//⇒ res15: kotlin.Double = 300.0


//Calling some methods on numbers
2.times(3)
//⇒ res5: kotlin.Int = 6

3.5.plus(4)
//⇒ res8: kotlin.Double = 7.5

2.4.div(2)
//⇒ res9: kotlin.Double = 1.2

val i: Int = 6
val b1 = i.toByte()
println(b1)

val b2: Byte = 1 // OK, literals are checked statically
println(b2)
1
/*
val i1: Int = b2
//⇒ error: type mismatch: inferred type is Byte but Int was expected

val i2: String = b2
//⇒ error: type mismatch: inferred type is Byte but String was expected

val i3: Double = b2
//⇒ error: type mismatch: inferred type is Byte but Double was expected
*/
val i4: Int = b2.toInt() // OK!
println(i4)
//⇒ 1

val i5: String = b2.toString()
println(i5)
//⇒ 1

val i6: Double = b2.toDouble()
println(i6)
//⇒ 1.0

/*
var fish = 1
fish = 2
val aquarium = 1
aquarium = 2
//Lesson1.kts:80:1: error: 'val' cannot be reassigned.
//aquarium = 2

var fish: Int = 12
var lakes: Double = 2.5
*/
/*
*Step 4: Learn about strings and characters
val numberOfFish = 5
val numberOfPlants = 12
"I have $numberOfFish fish" + " and $numberOfPlants plants"
//I have 5 fish and 12 plants

//Create a string template with an expression in it. As in other languages, the value can be the result of an expression. Use curly braces {} to define the expression.
"I have ${numberOfFish + numberOfPlants} fish and plants"
//I have 17 fish and plants
*/
//3. Compare conditions and booleans

val numberOfFish = 50
val numberOfPlants = 23
if (numberOfFish > numberOfPlants) {
    println("Good ratio!")
} else {
    println("Unhealthy ratio")
}
//Good ratio!
val fish = 50
if (fish in 1..100) {
    println(fish)
}
//50

if (numberOfFish == 0) {
    println("Empty tank")
} else if (numberOfFish < 40) {
    println("Got fish!")
} else {
    println("That's a lot of fish!")
}
//That's a lot of fish!

when (numberOfFish) {
    0  -> println("Empty tank")
    in 1..39 -> println("Got fish!")
    else -> println("That's a lot of fish!")
}
//That's a lot of fish!


//4. Learn about nullability
//var rocks: Int = null
//Lesson1.kts:131:18: error: null cannot be a value of a non-null type 'kotlin.Int'
/*
var marbles: Int? = null

var fishFoodTreats = 6
if (fishFoodTreats != null) {
    fishFoodTreats = fishFoodTreats.dec()
}

var fishFoodTreats = 6
fishFoodTreats = fishFoodTreats?.dec()

fishFoodTreats = fishFoodTreats?.dec() ?: 0

val len = s!!.length   // throws NullPointerException if s is null
*/

//5. Explore arrays, lists, and loops
/*
val school = listOf("mackerel", "trout", "halibut")
println(school)
//[mackerel, trout, halibut]
*/
val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")
//true. remove() returns true when successful

// Create arrays
val school = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(school))
//[shark, salmon, minnow]

val mix = arrayOf("fish", 2)
//An array declared with arrayOf doesn't have a type associated with the elements, so you can mix types,


val numbers = intArrayOf(1,2,3)
val numbers3 = intArrayOf(4,5,6)
val foo2 = numbers3 + numbers
println(foo2[5])
//3


val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)
//[[I@4c69b396, [Atlantic, Pacific], salmon]

//Initializing array with code instead of with 0
val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))
//[0, 2, 4, 6, 8]

//loop
for (element in school) {
    print(element + " ")
}
//shark salmon minnow

for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}
//Item at 0 is shark
//
//Item at 1 is salmon
//
//Item at 2 is minnow

for (i in 1..5) print(i)
// 12345

for (i in 5 downTo 1) print(i)
//54321

for (i in 3..6 step 2) print(i)
//35

for (i in 'd'..'g') print (i)
//defg

var bubbles = 0
while (bubbles < 50) {
    bubbles++
}
println("$bubbles bubbles in the water\n")

do {
    bubbles--
} while (bubbles > 50)
println("$bubbles bubbles in the water\n")

repeat(2) {
    println("A fish is swimming")
}
//50 bubbles in the water
//
//49 bubbles in the water
//
//A fish is swimming
//A fish is swimming