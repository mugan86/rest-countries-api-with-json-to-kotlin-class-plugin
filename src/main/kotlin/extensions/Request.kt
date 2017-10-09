package extensions

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Created by anartzmugika on 9/10/17.
 */
class Request {
    fun getHttpGETAPI(request_url: String): String {

        val url: URL
        var reader: BufferedReader? = null
        var stringBuilder: StringBuilder
        var connection: HttpsURLConnection? = null


        println("Request URL: " + request_url)

        try {
            // create the HttpURLConnection
            url = URL(request_url)

            connection = url.openConnection() as HttpsURLConnection
            // just want to do an HTTP GET here
            connection.requestMethod = "GET"

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);
            connection.useCaches = true
            connection.addRequestProperty("Cache-Control", "50")

            connection.connectTimeout = 40000
            // give it 40 seconds to respond
            connection.readTimeout = 40000
            connection.connect()

            println("Response code: " + connection.responseCode)
            println("Response message: " + connection.responseMessage)

            // read the output from the server
            reader = BufferedReader(InputStreamReader(connection.inputStream))
            stringBuilder = StringBuilder()

            var line: String? = null
            val reader = BufferedReader(reader)
            while ({ line = reader.readLine(); line }() != null) {
                System.out.println(line);
                stringBuilder = stringBuilder.append(line)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close()
                    connection!!.disconnect()
                } catch (ioe: IOException) {
                    ioe.printStackTrace()
                }

            }
        }
        return stringBuilder.toString()
    }
}
