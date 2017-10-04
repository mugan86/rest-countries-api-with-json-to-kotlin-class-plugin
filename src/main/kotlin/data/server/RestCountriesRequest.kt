package data.server

import com.google.gson.Gson
import domain.models.RestCountries
import java.net.URL
import com.google.gson.reflect.TypeToken

/******************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 04/10/2017.
 * Take data from server
 ******************************************************************************************************************/
class RestCountriesRequest() {
    companion object {
        private val URL_LOCALHOST = "https://restcountries.eu/rest/v2/all"
    }

    fun execute() : List<RestCountries> = Gson().fromJson(URL(URL_LOCALHOST).readText(), object : TypeToken<List<RestCountries>>() {}.type)
}