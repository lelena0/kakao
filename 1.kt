interface Runnable {
    fun run()
}

interface Swimmable {
    fun swim()
}

abstract class Pet(val runSpeed: Int, val swimSpeed: Int) {
    val totalSpeed: Int
        get() = runSpeed + swimSpeed
}

class Cat(runSpeed: Int, swimSpeed: Int) : Pet(runSpeed, swimSpeed), Runnable, Swimmable {
    override fun run() {
        println("I am a Cat, and I'm running")
    }

    override fun swim() {
        println("I am a Cat, and I'm swimming")
    }
}

class Fish(swimSpeed: Int) : Pet(0, swimSpeed), Swimmable {
    override fun swim() {
        println("I am a Fish, and I'm swimming")
    }
}

class PetSwimQueue {
    private val queue: MutableList<Swimmable> = mutableListOf()

    fun enqueue(pet: Swimmable) {
        queue.add(pet)
    }

    fun dequeue(): Swimmable? {
        if (queue.isNotEmpty()) {
            return queue.removeAt(0)
        }
        return null
    }
}

fun main() {
    val cat = Cat(10, 5)
    val fish = Fish(15)

    val petQueue = PetSwimQueue()
    petQueue.enqueue(cat)
    petQueue.enqueue(fish)

    val dequeuedPet = petQueue.dequeue()
    dequeuedPet?.swim()
}
