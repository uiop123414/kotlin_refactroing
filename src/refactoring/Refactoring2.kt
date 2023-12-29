package refactoring

data class User(val name: String)

class UserRepository {
    private val storedUsers: MutableMap<Int, User> = mutableMapOf()

    fun loadAll(): Map<Int, User> {
        return storedUsers.toMap()
    }
}
