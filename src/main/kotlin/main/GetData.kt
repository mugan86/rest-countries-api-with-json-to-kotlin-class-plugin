package main
import data.ConstantValues
import data.local.db.DbHelper
import domain.commands.RequestCurrencyCommand
import domain.models.*
import utils.cleanStringResult


/**********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 4/10/17.
 * Take data from server and insert correctly in select table
 *********************************************************************************************************************/

fun main(args: Array<String>) {

    val result = RequestCurrencyCommand().execute()
    println("Total countries is ${result.size} countries.")
    result.forEach { country ->
        printValues(country)
        /*insertAllCountriesInMainTable(country)
        insertCurrencies(country.cioc, country.currencies)
        insertTranslations(country.cioc, country.translations)
        insertRegionalBlocks(country.cioc, country.regionalBlocs)
        insertLanguages(country.cioc, country.languages)*/
        //addWikipediaURL()
    }

}

private fun printValues(country: RestCountries) {
    println("********************************************************")
    println("Name: 			 ${country.name}")
    println("Flag: 			 https://restcountries.eu/data/${country.alpha3Code.toLowerCase()}.svg")
    println("Area: 			 ${country.area} km^2")
    println("Capital: 		 ${country.capital}")
    println("Native name: 	 ${country.nativeName}")
    println("Population: 	 ${country.population}")
}


private fun insertCurrencies(cioc: String, currencies: List<Currency>) {
    currencies.forEach {
        currency->
        val db = DbHelper()
        val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
        list.add(cioc)
        list.add(currency.code)
        list.add(currency.name)
        list.add(currency.symbol)
        db.executeInsertUpdateOperation(ConstantValues.insertCurrencies, list)
    }
}

private fun insertTranslations(cioc: String, translations: Translations) {
    val db = DbHelper()
    val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
    list.add(cioc)
    list.add(translations.de)
    list.add(translations.es)
    list.add(translations.fr)
    list.add(translations.ja)
    list.add(translations.it)
    list.add(translations.br)
    list.add(translations.pt)
    list.add(translations.nl)
    list.add(translations.hr)
    list.add(translations.fa)
    db.executeInsertUpdateOperation(ConstantValues.insertTranslations, list)
}

private fun insertRegionalBlocks(cioc: String, regionalBloc: List<RegionalBloc>) {
    regionalBloc.forEach {
        block->
        val db = DbHelper()
        val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
        list.add(cioc)
        list.add(block.acronym)
        list.add(block.name)
        list.add(cleanStringResult(block.otherNames.toString()))
        list.add(cleanStringResult(block.otherNames.toString()))
        db.executeInsertUpdateOperation(ConstantValues.insertRegionalBlocks, list)
    }

}

private fun insertLanguages(cioc: String, languages: List<Language>) {
    languages.forEach {
        language->
        val db = DbHelper()
        val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
        list.add(cioc)
        list.add(language.iso6391)
        list.add(language.iso6392)
        list.add(language.name)
        list.add(language.nativeName)
        db.executeInsertUpdateOperation(ConstantValues.insertLanguages, list)
    }
}

private fun showAllCountries() {
    val db = DbHelper()

    val dataFromDB = db.executeQuery(ConstantValues.ALL_COUNTRIES)
    while(dataFromDB.next()) {
        println(" ${dataFromDB.getString(1)} / ${dataFromDB.getString(2)} / ${dataFromDB.getString(3)}")
    }
    db.close();
}

private fun insertAllCountriesInMainTable(country: RestCountries) {
    try {
        val db = DbHelper()
        val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
        list.add(country.alpha3Code)
        list.add(country.name)
        list.add(cleanStringResult(country.topLevelDomain.toString()))
        list.add(country.alpha2Code)
        list.add(country.alpha3Code)
        list.add(cleanStringResult(country.callingCodes.toString()))
        list.add(country.capital)
        list.add(cleanStringResult(country.altSpellings.toString()))
        list.add(country.region)
        list.add(country.subregion)
        list.add(country.population.toString())
        val latLng = cleanStringResult(country.latlng.toString())
        list.add(latLng.substring(0, latLng.indexOf(",")))
        list.add(latLng.substring(latLng.indexOf(",") + 2))
        list.add(country.demonym)
        list.add(country.area.toString())
        list.add(country.gini.toString())
        list.add(cleanStringResult(country.timezones.toString()))
        list.add(cleanStringResult(country.borders.toString()))
        list.add(country.nativeName)
        list.add(country.numericCode)
        list.add(country.alpha3Code.toLowerCase())
        println(list.size)

        db.prepareAndExecuteQueryAllCountries(ConstantValues.insertValue, list)
        db.close()
    } catch (e: Exception) {
        println("NOT CORRECT!!!")
    }
}

private fun addWikipediaURL() {
    val db = DbHelper();
    val dataFromDB = db.executeQuery(ConstantValues.ALL_COUNTRIES_ONLY_NAME_CODE)
    while(dataFromDB.next()) {
        println(" ${dataFromDB.getString(1)} / ${dataFromDB.getString(2)} / ${createWikipediaURL(dataFromDB.getString(2))}")
        val list: ArrayList<String> = mutableListOf<String>() as ArrayList<String>
        list.add(createWikipediaURL(dataFromDB.getString(2)))
        list.add(dataFromDB.getString(1))
        db.executeInsertUpdateOperation(ConstantValues.addWikipediaURL, list)
    }
    db.close();

    // UPDATE `rescountries_country` SET `url` = 'https://en.m.wikipedia.org/wiki/Aruba' WHERE `rescountries_country`.`cioc` = 'ABW';
}

private fun createWikipediaURL(name:String): String {
    return "${ConstantValues.WIKIPEDIA_URL}${name.replace(" ", "_")}"
}