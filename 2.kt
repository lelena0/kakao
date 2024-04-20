val addition: (Double, Double) -> Double = { a, b -> a + b }
val subtraction: (Double, Double) -> Double = { a, b -> a - b }
val multiplication: (Double, Double) -> Double = { a, b -> a * b }
val division: (Double, Double) -> Double = { a, b ->
    if (b != 0.0) {
        a / b
    } else {
        throw IllegalArgumentException("Деление на ноль")
    }
}

fun getOperation(symbol: String): (Double, Double) -> Double {
    return when (symbol) {
        "+" -> addition
        "-" -> subtraction
        "*" -> multiplication
        "/" -> division
        else -> throw UnsupportedOperationException("Неверный символ операции")
    }
}

fun main() {
    val leftOperand = 10.0
    val rightOperand = 5.0

    val operations = listOf("+", "-", "*", "/")

    for (operationSymbol in operations) {
        val operation = getOperation(operationSymbol)
        try {
            val result = calculator(operation, leftOperand, rightOperand)
            println("$leftOperand $operationSymbol $rightOperand = $result")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}

fun calculator(operation: (Double, Double) -> Double, leftOperand: Double, rightOperand: Double): Double {
    return operation(leftOperand, rightOperand)
}
