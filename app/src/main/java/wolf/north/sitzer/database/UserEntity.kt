package wolf.north.sitzer.database

import androidx.room.Entity
import androidx.room.PrimaryKey

//create db table users with parameters
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val userID: Int = 0,
    val firstName: String,
    val email : String,
    val password: String
)