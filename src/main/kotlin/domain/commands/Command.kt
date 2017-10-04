package domain.commands

/**********************************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 4/10/17.
 * Add interface to command execute
 *********************************************************************************************************************/
interface Command<out T> {
    fun execute(): T
}