package refactoring

// example from Effective Kotlin

fun doLogic() {
    val users = listOf<User>() // Assuming users list is initialized elsewhere

    for ((index, user) in users.withIndex()) {
        println("User at $index is $user")
    }
}
