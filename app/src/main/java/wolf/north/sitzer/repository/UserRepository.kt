package wolf.north.sitzer.repository

import wolf.north.sitzer.database.UserDao
import wolf.north.sitzer.database.UserEntity
import wolf.north.sitzer.mvvm.model.User
import javax.inject.Inject


//bridge between database entity and User model in mvvm
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun registerUserWithCredentials(firstName: String, email: String, password: String) {
        val userEntity = UserEntity(firstName = firstName, email = email, password = password)
        userDao.insertUser(userEntity)
    }

    suspend fun loginUser(email: String, password: String): User? {
        val entity = userDao.loginUser(email, password)
        return entity?.let { User(it.firstName, it.email, it.password) }
    }
}