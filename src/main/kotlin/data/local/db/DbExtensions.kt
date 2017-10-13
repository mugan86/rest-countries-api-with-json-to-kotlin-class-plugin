package data.local.db

import java.sql.PreparedStatement
import java.sql.ResultSet

/***********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 13/10/17.
 * Extensions to use in MySQL driver
 ***********************************************************************************************************************/
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