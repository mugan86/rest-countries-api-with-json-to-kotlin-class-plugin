package domain.models

import com.google.gson.annotations.SerializedName

/***********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 4/10/17.
 * Generate data classes with "Convert JSON into Kotlin class": https://github.com/wuseal/JsonToKotlinClass
 * Use https://restcountries.eu/rest/v2/all to taje JSON info to make all Data classes with use GSON library
 **********************************************************************************************************************/
data class RestCountries(
        @SerializedName("name") val name: String = "", //Afghanistan
        @SerializedName("topLevelDomain") val topLevelDomain: List<String> = listOf(),
        @SerializedName("alpha2Code") val alpha2Code: String = "", //AF
        @SerializedName("alpha3Code") val alpha3Code: String = "", //AFG
        @SerializedName("callingCodes") val callingCodes: List<String> = listOf(),
        @SerializedName("capital") val capital: String = "", //Kabul
        @SerializedName("altSpellings") val altSpellings: List<String> = listOf(),
        @SerializedName("region") val region: String = "", //Asia
        @SerializedName("subregion") val subregion: String = "", //Southern Asia
        @SerializedName("population") val population: Int = 0, //27657145
        @SerializedName("latlng") val latlng: List<Double> = listOf(),
        @SerializedName("demonym") val demonym: String = "", //Afghan
        @SerializedName("area") val area: Double = 0.0, //652230.0
        @SerializedName("gini") val gini: Double = 0.0, //27.8
        @SerializedName("timezones") val timezones: List<String> = listOf(),
        @SerializedName("borders") val borders: List<String> = listOf(),
        @SerializedName("nativeName") val nativeName: String = "", //افغانستان
        @SerializedName("numericCode") val numericCode: String = "", //004
        @SerializedName("currencies") val currencies: List<Currency> = listOf(),
        @SerializedName("languages") val languages: List<Language> = listOf(),
        @SerializedName("translations") val translations: Translations = Translations(),
        @SerializedName("flag") val flag: String = "", //https://restcountries.eu/data/afg.svg
        @SerializedName("regionalBlocs") val regionalBlocs: List<RegionalBloc> = listOf(),
        @SerializedName("cioc") val cioc: String = "" //AFG
)

data class Translations(
        @SerializedName("de") val de: String = "", //Afghanistan
        @SerializedName("es") val es: String = "", //Afganistán
        @SerializedName("fr") val fr: String = "", //Afghanistan
        @SerializedName("ja") val ja: String = "", //アフガニスタン
        @SerializedName("it") val it: String = "", //Afghanistan
        @SerializedName("br") val br: String = "", //Afeganistão
        @SerializedName("pt") val pt: String = "", //Afeganistão
        @SerializedName("nl") val nl: String = "", //Afghanistan
        @SerializedName("hr") val hr: String = "", //Afganistan
        @SerializedName("fa") val fa: String = "" //افغانستان
)

data class Language(
        @SerializedName("iso639_1") val iso6391: String = "", //ps
        @SerializedName("iso639_2") val iso6392: String = "", //pus
        @SerializedName("name") val name: String = "", //Pashto
        @SerializedName("nativeName") val nativeName: String = "" //پښتو
)

data class Currency(
        @SerializedName("code") val code: String = "", //AFN
        @SerializedName("name") val name: String = "", //Afghan afghani
        @SerializedName("symbol") val symbol: String = "" //؋
)

data class RegionalBloc(
        @SerializedName("acronym") val acronym: String = "", //SAARC
        @SerializedName("name") val name: String = "", //South Asian Association for Regional Cooperation
        @SerializedName("otherAcronyms") val otherAcronyms: List<Any> = listOf(),
        @SerializedName("otherNames") val otherNames: List<Any> = listOf()
)