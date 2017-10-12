package data.local.db

import java.sql.PreparedStatement
import java.sql.ResultSet

/**
 * Created by anartzmugika on 12/10/17.
 */
fun PreparedStatement.update(): Int {
    try {
        return this.executeUpdate()
    } finally {
        close()
    }
}

fun <T> PreparedStatement.query(block: (ResultSet) -> T): T {
    try {
        val resultSet = this.executeQuery()
        return block(resultSet)
    } finally {
        close()
    }
}