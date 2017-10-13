package data.local.db

import java.sql.Statement
import java.sql.Connection
import java.sql.ResultSet

/***********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 13/10/17.
 * Manage Local DB operations
 ***********************************************************************************************************************/
class DbHelper {
    private var connection: Connection?

    init {
        connection = Connection().connectToDB()
    }

    fun executeQuery(sql: String): ResultSet = (connection?.createStatement() as Statement).executeQuery(sql)

    fun executeInsertUpdateOperation(sql: String, listParameters : ArrayList<String>) {
        val statement = connection?.prepareStatement(sql)
        var i = 0
        listParameters.map {
            statement?.setString((i + 1), listParameters.get(i))
            i++
        }
        statement?.update()
    }

    fun prepareAndExecuteQueryAllCountries(sql: String, listParameters : ArrayList<String>) {
        val statement = connection?.prepareStatement(sql)
        statement?.setString(1, listParameters.get(0))
        statement?.setString(2, listParameters.get(1))
        statement?.setString(3, listParameters.get(2))
        statement?.setString(4, listParameters.get(3))
        statement?.setString(5, listParameters.get(4))
        statement?.setString(6, listParameters.get(5))
        statement?.setString(7, listParameters.get(6))
        statement?.setString(8, listParameters.get(7))
        statement?.setString(9, listParameters.get(8))
        statement?.setString(10, listParameters.get(9))
        statement?.setInt(11, listParameters.get(10).toInt())
        statement?.setString(12, listParameters.get(11))
        statement?.setString(13, listParameters.get(12))
        statement?.setString(14, listParameters.get(13))
        statement?.setString(15, listParameters.get(14))
        statement?.setString(16, listParameters.get(15))
        statement?.setString(17, listParameters.get(16))
        statement?.setString(18, listParameters.get(17))
        statement?.setString(19, listParameters.get(18))
        statement?.setString(20, listParameters.get(19))
        statement?.setString(21, listParameters.get(20))
        statement?.update()
    }

    fun close() {
        connection?.close()
    }
}