package data

/**
 * Created by anartzmugika on 12/10/17.
 */
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

    }

}