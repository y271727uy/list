// 文件：Main.kt

import kotlin.math.PI

// 定义一个数据类
data class Circle(val radius: Double) {
    val area: Double
        get() = PI * radius * radius

    val circumference: Double
        get() = 2 * PI * radius
}

// 定义一个接口
interface Greetable {
    fun greet(): String
}

// 实现接口
class Person(val name: String, val age: Int) : Greetable {
    override fun greet(): String {
        return "Hello, my name is $name, I'm $age years old."
    }
}

// 扩展函数
fun String.addExclamation() = "$this!"

// 主函数（程序入口）
fun main() {
    // 使用数据类
    val circle = Circle(5.0)
    println("Circle area: ${circle.area}")
    println("Circle circumference: ${circle.circumference}")

    // 使用类和接口
    val person = Person("Alice", 28)
    println(person.greet())

    // 使用扩展函数
    val message = "This is Kotlin"
    println(message.addExclamation())

    // 集合操作
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenSquares = numbers
        .filter { it % 2 == 0 }
        .map { it * it }

    println("Even squares: $evenSquares")

    // 空安全处理
    val nullableString: String? = "Nullable value"
    val length = nullableString?.length ?: 0
    println("Length: $length")

    // 使用 when 表达式
    val score = 85
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
    println("Grade: $grade")
}