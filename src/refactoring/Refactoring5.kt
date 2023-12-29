package refactoring

data class Person(val isAdult: Boolean = true)

fun doSomeLogic(person: Person?): Person? {
    if (person?.isAdult == true) {
        // show person
        return person
    } else {
        // show error
        throw Exception()
    }
}
