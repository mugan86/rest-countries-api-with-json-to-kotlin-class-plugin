package main
import domain.commands.RequestCurrencyCommand
import extensions.FileManage
import extensions.Request

/**********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 4/10/17.
 * Take data from server and print data in console
 *********************************************************************************************************************/
fun main(args: Array<String>) {
    val result = RequestCurrencyCommand().execute()
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
        FileManage().createFile(country.alpha3Code.toLowerCase(), "svg", "images", Request().getHttpGETAPI(country.flag))

    }

}