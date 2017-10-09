package extensions

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by anartzmugika on 5/10/17.
 */

class FileManage {
    fun createFile(name: String?, extension: String, directoryName: String, data: String) {

            val bfw: BufferedWriter

            //Check directory exist or no
            checkIfDirectoryExistAndIfNotExistCreate("Results/")

            var assetsDirectory = ""
            if (directoryName != "") assetsDirectory = "$directoryName/"


            try {
                //Sartutakoa zer fitxategitan gordeko dan zehaztuko da "true" propeitatearekin
                //idaztean ez duela aurrekoa matxakatuko, hau da aurrekoak mantenduz sartutako
                //gehituko da
                bfw = BufferedWriter(FileWriter("Results/$assetsDirectory${name}.${extension}", false))
                bfw.write(data)
                bfw.newLine()
                //close flux or file after save
                bfw.close()
            } catch (ioe: IOException) {
                println("IOException: " + ioe.message.toString())
            }

    }

    fun readFile(directory: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun checkIfDirectoryExistAndIfNotExistCreate(directoryName: String) {
        //Add to create in C:// ---> Path "/Results"
        //Add inside project without "/"---> Results
        val path = Paths.get(directoryName)
        if (!Files.exists(path)) {
            println("NOT!! Exist")
            try {
                Files.createDirectories(path)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else {
            println("Exist directory")
        }
    }
}