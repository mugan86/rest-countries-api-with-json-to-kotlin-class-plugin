package data

/***********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 13/10/17.
 * Define use all constants. URL LOCALHOST to get API data and Database connections and queries
 ***********************************************************************************************************************/
class ConstantValues() {
    companion object {
        val URL_LOCALHOST = "https://restcountries.eu/rest/v2/all"

        //DATABASE Values
        private val DB_NAME = "restcountries"
        private val USE_UNICODE = "?useUnicode=yes&characterEncoding=UTF-8&relaxAutoCommit=true"
        val URL_DB = "jdbc:mysql://localhost:3306/" + DB_NAME + USE_UNICODE
        val USER = "root"
        val PASS = ""

        val ALL_COUNTRIES = "SELECT * FROM `rescountries_country`"

        val insertValue = "INSERT IGNORE INTO `rescountries_country` (`cioc`, `name`, `topLevelDoimain`, `alpha2Code`, `alpha3Code`, `callingCodes`, `capital`, `altSpellings`, `region`, `subregion`, `population`, `lat`, `lng`, `demonym`, `area`, `gini`, `timezones`, `borders`, `nativeName`, `numericCode`, `flag`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"

        val insertTranslations = "INSERT IGNORE INTO `restcountries_translations` (`cioc`, `de`, `es`, `fr`, `ja`, `it`, `br`, `pt`, `nl`, `hr`, `fa`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        val insertRegionalBlocks = "INSERT IGNORE INTO `restcountries_regionalbloc` (`cioc`, `acronym`, `name`, `otherAcronyms`, `otherNames`)" +
                "VALUES (?, ?, ?, ?, ?)"

        val insertLanguages = "INSERT IGNORE INTO `restcountries_language` (`cioc`, `iso639_1`, `iso639_2`, `name`, `nativeName`)" +
                "VALUES (?, ?, ?, ?, ?)"

        val insertCurrencies = "INSERT IGNORE INTO `restcountries_currency` (`cioc`, `code`, `name`, `symbol`)" +
                "VALUES (?, ?, ?, ?)"

    }

}