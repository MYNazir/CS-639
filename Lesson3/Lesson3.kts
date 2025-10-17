// Lesson3.kts
// Line 1: Package declaration is the FIRST line of code
/*
package example.myapp
/*import java.lang.Math.PI
import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length
import com.sun.tools.javac.jvm.Code.width
import javax.swing.Spring.height

//val volume: kotlin.Any



/*
// Line 2: (Optional) Define the variables
val width = 10.0
val length = 20.0
val height = 5.0

// Line 5: Define the function
fun printSize() {
    println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm ")
}

// Line 10: (Optional) Call the function to run it
printSize()
//Width: 10.0 cm Length: 20.0 cm Height: 5.0 cm
// Lesson3.kts

// 1. PACKAGE MUST BE HERE - On the very first line!

// 2. Add necessary imports (if any, like for a custom class)
/*
// 3. Define the missing Aquarium class (or import it)
class Aquarium {
    fun printSize() {
        println("The aquarium size is default.") // Example implementation
    }
}

// 4. Single, consolidated function definition
fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}
*/
// 5. Main function to execute the code
fun main() {
    buildAquarium()
}

// If you had any extra lines or comments before the 'package' line,
// that would also cause the error on line 20.
 */
/*
class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
    // Dimensions in cm
    var length: Int = length
    var width: Int = width
    var height: Int = height
    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }

}
fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}
*/
/*
// 1. Define the class with properties and a Primary Constructor
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    fun printSize() { // The function that was missing
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm")
    }
}
    // 2. Define a class property 'volume' to hold the calculated size in liters
    var volume: Int

    // Initializer block (optional, but a good place to set initial 'volume')
    init {
        // Calculate volume in cm^3 and convert to liters (1000 cm^3 = 1 liter)
        volume = (length * width * height) / 1000
    }

    // 3. The Secondary Constructor from your selection
    //    It takes 'numberOfFish' and calls the primary constructor (: this())
    constructor(numberOfFish: Int) : this() {
        // Calculate the required volume in cm^3: 2000 cm^3 per fish + 10% extra
        val tank = numberOfFish * 2000 * 1.1

        // Convert cm^3 to Liters and assign it to the class property 'volume'
        // This is where you set the class property based on the calculation
        volume = (tank / 1000).toInt()
        // calculate the height needed
        height = (tank / (length * width)).toInt()

    }
}
/*  aquarium initializing
        Volume: 80 liters
        Width: 20 cm Length: 100 cm Height: 40 cm
        aquarium initializing
        Volume: 100 liters
        Width: 25 cm Length: 100 cm Height: 40 cm
        aquarium initializing
        Volume: 77 liters
        Width: 20 cm Length: 110 cm Height: 35 cm
        aquarium initializing
        Volume: 96 liters
        Width: 25 cm Length: 110 cm Height: 35 cm

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")
}

// Example assuming you need 2 liters per fish
class Aquarium(
    // Existing parameters
    var length: Int = 100,
    var width: Int = 20,
    var height: Int = 40,

    // **ADD THIS PARAMETER**
    numberOfFish: Int = 0 // The name the compiler was looking for
) {
    // You can use the 'numberOfFish' value in initialization logic or other properties
    val volume: Int
        get() = width * length * height / 1000 // in liters

    // Calculate required volume based on fish (e.g., 2 liters per fish)
    val requiredVolume = numberOfFish * 2

    // An init block can check if the current volume is sufficient
    init {
        println("The required volume for $numberOfFish fish is $requiredVolume liters.")
        if (volume < requiredVolume) {
            println("WARNING: Aquarium is too small for $numberOfFish fish! Volume: $volume L")
        }
    }
}
*/



 */
/*
var volume: Int
    get() = width * height * length / 1000
    private set(value) {
        height = (value * 1000) / (width * length)
    }
*/
import java.lang.Math.PI // Required for the PI constant in TowerTank

// Step 1: Make the Aquarium class and its members 'open'
        open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {

    // Open property with custom getter/setter
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    // Open read-only property
    open val shape = "rectangle"

    // Open property with custom getter (90% of volume)
    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        // Add calculation for water percentage
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

// ---

// Step 2: Create a subclass TowerTank
class TowerTank (override var height: Int, var diameter: Int):
// Call the superclass constructor, using diameter for width and length
    Aquarium(height = height, width = diameter, length = diameter) {

    // Override the volume property for a cylinder shape
    override var volume: Int
        // Formula for cylinder volume: π * r² * h
        // Since length/width are equal to diameter, r = length/2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    // Override the water property (80% of volume)
    override var water: Double = volume * 0.8

    // Override the shape property
    override val shape = "cylinder"
}


fun buildAquarium() {
    // Original Aquarium instance (rectangle) with specific size
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()

    // ---

    // TowerTank subclass instance (cylinder) with specific size
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

// The main function to run the code
fun main() {
    buildAquarium()
}
*/



// Step 2: Create an interface
interface FishAction {
    fun eat()
}

// Step 1: Create an abstract class, and implement the interface
abstract class AquariumFish : FishAction {
    // Abstract property - must be implemented by subclasses
    abstract val color: String

    // Default implementation for eat() (Optional structure from the end of the content)
    // The content shows two versions, this is the one where the abstract class implements the interface
    override fun eat() = println("yum")
}

// Subclass implementing the abstract property and overriding the interface method
class Shark: AquariumFish(), FishAction {
    override val color = "grey"

    // Override the interface method (or the default implementation in AquariumFish)
    override fun eat() {
        println("hunt and eat fish")
    }
}

// Subclass implementing the abstract property and overriding the interface method
class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"

    // Override the interface method (or the default implementation in AquariumFish)
    override fun eat() {
        println("eat algae")
    }
}
//main


fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    // Print color and call eat() for Shark
    println("Shark: ${shark.color}")
    shark.eat()

    // Print color and call eat() for Plecostomus
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    // Call the test function
    makeFish()
}
*/
/*
package example.myapp

// Interface defining the behavior (action)
interface FishAction {
    fun eat()
}

// Interface defining the property (color)
interface FishColor {
    val color: String
}

// Step 2: Singleton object acting as a delegate for a common color
// Using 'object' creates a single, reusable instance (Singleton pattern)
object GoldColor : FishColor {
    override val color = "gold"
}

// Step 4: Class acting as a delegate for the FishAction interface
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

// Step 3 & 4: Plecostomus class using interface delegation for both FishAction and FishColor.
// It delegates its 'color' implementation to the passed-in fishColor (defaults to GoldColor).
// It delegates its 'eat' implementation to a new PrintingFishAction instance.
class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

// Step 1: Shark class still using explicit implementation (for comparison)
// Note: In a real-world scenario, Shark could also use delegation, e.g., for its color.
class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}



fun makeFish() {
    // Create Plecostomus instance, using default GoldColor delegation
    val pleco = Plecostomus()

    // Create a new Shark instance (uses explicit implementation)
    val shark = Shark()

    // Test Plecostomus (Delegated Color and Action)
    println("Plecostomus color: ${pleco.color}") // Color retrieved via GoldColor delegate
    pleco.eat() // Action performed via PrintingFishAction delegate

    // Test Shark (Explicit Implementation)
    println("Shark color: ${shark.color}")
    shark.eat()
}

fun main () {
    makeFish()
}
*/
/*
package example.myapp.decor

// Step 1: Create a simple data class
data class Decoration(val rocks: String)

// Step 2: Create a data class with multiple properties for destructuring example
data class Decoration2(val rocks: String, val wood: String, val diver: String)

fun makeDecorations() {
    // --- Decoration Class Example ---

    // 1. Instantiating and printing a data class (uses a sensible toString)
    val decoration1 = Decoration("granite")
    println("Decoration 1: $decoration1")

    val decoration2 = Decoration("slate")
    println("Decoration 2: $decoration2")

    val decoration3 = Decoration("slate")
    println("Decoration 3: $decoration3")

    // 2. Using equals() (structural equality)
    println("decoration1 equals decoration2: ${decoration1.equals(decoration2)}")
    println("decoration3 equals decoration2: ${decoration3.equals(decoration2)}")

    // --- Decoration2 Destructuring Example ---

    val d5 = Decoration2("crystal", "wood", "diver")
    println("\nDecoration 5: $d5")

    // 3. Destructuring all properties
    val (rock, wood, diver) = d5
    println("Destructuring (all):")
    println("Rock: $rock")
    println("Wood: $wood")
    println("Diver: $diver")

    // 4. Destructuring with underscore to skip properties
    val (mainRock, _, mainDiver) = d5
    println("\nDestructuring (skipping wood):")
    println("Main Rock: $mainRock")
    println("Main Diver: $mainDiver")
}

fun main () {
    makeDecorations()
}
*/

// Define a functional interface/class for demonstration
interface FishColor {
    val color: String
}

// Step 1: Recall singleton classes
// Declared as 'object', making it a singleton.
// There can be only one instance of GoldColor.
object GoldColor : FishColor {
    override val color = "gold"
}

// Step 2: Create an enum - Example 1
// Enum class with a constructor and associated field (rgb)
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
    // Note the semicolon after the last enum constant if
    // the enum class contains properties or methods.
}

// Step 2: Create an enum - Example 2
// Enum class with a constructor and associated field (degrees)
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
    // Demonstrate the singleton object
    println("--- Singleton Object Demonstration ---")
    println("The color is: ${GoldColor.color}") // Accessing the singleton instance property

    // Demonstrate the Direction enum
    println("\n--- Enum Demonstration (Direction.EAST) ---")

    // Using the name property
    println("Name: ${Direction.EAST.name}")

    // Using the ordinal property (position in the declaration, starting from 0)
    println("Ordinal: ${Direction.EAST.ordinal}")

    // Using the custom associated field
    println("Degrees: ${Direction.EAST.degrees}")

    // Demonstrate the Color enum
    println("\n--- Enum Demonstration (Color.GREEN) ---")
    println("Name: ${Color.GREEN.name}")
    println("RGB value: ${Color.GREEN.rgb} (Hex: 0x${Color.GREEN.rgb.toString(16).uppercase()})")
}