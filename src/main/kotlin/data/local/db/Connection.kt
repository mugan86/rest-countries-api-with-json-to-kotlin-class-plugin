package data.local.db

import data.ConstantValues
import java.sql.Connection
import java.sql.DriverManager

/**
 * Created by anartzmugika on 12/10/17.
 */


class Connection {
    fun connectToDB(): Connection? {
        try {
            //Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver")
            //Make connection with database
            return DriverManager.getConnection(ConstantValues.URL_DB, ConstantValues.USER, ConstantValues.PASS)
        } catch (e: Exception) {
            return null
        }
    }
}