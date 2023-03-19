import kotlin.reflect.typeOf
import java.util.Scanner

object UserDialog {

    fun showScreenName(screenId: Int, archiveName: String = "", noteName: String = "") {
        val screenName = when(screenId) {
            0 -> "Выбор архива"
            1 -> "Создание архива"
            2 -> "Вы в архиве \"$archiveName\""
            3 -> "Создания заметки"
            4 -> "Вы на экране заметки \"$noteName\""
            else -> "Error"
        }
        println(screenName)
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T> showScreenContent(contentList: List<T>): Int {

        val typeClassifier = typeOf<T>().classifier

        if (typeClassifier == Archive::class) {
            (contentList as List<Archive>).forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
        } else if(typeClassifier == Note::class) {
            (contentList as List<Note>).forEachIndexed { index, note ->
                println("${index + 1}. ${note.name}")
            }
        }

        return contentList.size
    }

    fun showFirstBtn(screenId: Int) {
        val str = when(screenId) {
            0 -> "Создать архив"
            2 -> "Создать заметку"
            4 -> "Посмотреть заметку"
            else -> "Wrong screenId"
        }
        println("0. $str")
    }

    fun showBackBtn(contentSize: Int) = println("${contentSize + 1}. Назад")

    fun readInput(): String = Scanner(System.`in`).nextLine()

    fun showCreatorHeader(): Int {
        println("Введите название:")
        return 0
    }

    fun showChooseMessage() = println("Выберите один из пунктов и введите его номер:")

    fun showWriteTextMessage() = println("Введите текст заметки:")

}