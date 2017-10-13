package data.local.db

import java.sql.Statement
import java.sql.Connection
import java.sql.ResultSet

/**
 * Created by anartzmugika on 13/10/17.
 */
class DbHelper {
    private var connection: Connection?
    private var statement: Statement
    init {
        connection = Connection().connectToDB()
        statement = connection?.createStatement() as Statement
    }

    fun executeQuery(sql: String): ResultSet = this.statement.executeQuery(sql)

    fun executeInsertUpdateOperation() {

    }

    fun close() {
        connection?.close()
        statement.close()
    }
}