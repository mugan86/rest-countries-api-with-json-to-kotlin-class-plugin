package main
import data.ConstantValues
import data.local.db.Connection
import data.local.db.update
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Statement


/**********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 4/10/17.
 * Take data from server and print data in console
 *********************************************************************************************************************/
fun main(args: Array<String>) {
    /*val result = RequestCurrencyCommand().execute()
    println("Total countries is ${result.size} countries.")
    result.forEach { country ->
        println("***************************************************************")
        println("Name: \t\t\t ${country.name}")
        println("Flag: \t\t\t ${country.flag}")
        println("Area: \t\t\t ${country.area} km^2")
        println("Capital: \t\t ${country.capital}")
        println("Native name: \t ${country.nativeName}")
        println("Population: \t ${country.population}")
        println(Request().getHttpGETAPI(country.flag))
        // FileManage().createFile(country.alpha3Code.toLowerCase(), "svg", "images", Request().getHttpGETAPI(country.flag))
    }*/

    val connection = Connection().connectToDB()
    val statement = connection?.createStatement() as Statement
    val dataFromDB = (statement).executeQuery(ConstantValues.ALL_COUNTRIES)

    /*var psInsert: PreparedStatement? = null

    try {
        if(psInsert == null) {
            psInsert = connection.prepareStatement(ConstantValues.insertValue)
            psInsert.setString(1, ""); //
            psInsert.setString(2, ""); //
            psInsert.setString(3, ""); //
            psInsert.update()// insert execute
        }
    }catch (e: Exception) {

    }*/

    println(ConstantValues.insertValue)

    while(dataFromDB.next()) {
        println(" ${dataFromDB.getString(1)} / ${dataFromDB.getString(2)} / ${dataFromDB.getString(3)}")
    }
    connection.close()
    statement.close()


}