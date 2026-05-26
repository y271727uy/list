// hello.kts
import java.time.LocalDate

// 打印欢迎信息和当前日期
println("Hello from Kotlin script!")
println("Today is: ${LocalDate.now()}")

// 读取用户输入
print("Enter your name: ")
val name = readLine() ?: "Anonymous"

print("Enter first number: ")
val num1 = readLine()?.toIntOrNull() ?: 0

print("Enter second number: ")
val num2 = readLine()?.toIntOrNull() ?: 0

val sum = num1 + num2

println("Hello, $name!")
println("$num1 + $num2 = $sum")