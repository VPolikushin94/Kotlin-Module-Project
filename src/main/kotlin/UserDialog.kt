import kotlin.reflect.typeOf
import java.util.Scanner

object UserDialog {

    private var lastBtnNumber = 0

    fun showScreenName(screenId: Int, itemName: String = "", noteName: String = "") {
        val screenName = when(screenId) {
            0 -> "Выбор архива"
            1 -> "Создание архива"
            2 -> "Вы в архиве \"$itemName\""
            3 -> "Создания заметки"
            4 -> "Вы на экране заметки \"$itemName\""
            5 -> "Название: $itemName"
            else -> "Error"
        }
        println('\n' + screenName)
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

    fun showNote(text: String): Int {
        println("Текст заметки: $text")
        return 0
    }

    fun showFirstBtn(screenId: Int) {
        val str = when(screenId) {
            0 -> "Создать новый архив"
            2 -> "Создать новую заметку"
            4 -> "Посмотреть заметку"
            else -> "Wrong screenId"
        }
        println("0. $str")
    }

    fun showBackBtn(contentSize: Int) {
        lastBtnNumber = contentSize + 1
        println("$lastBtnNumber. Назад")
    }

    fun readInput(screenId: Int): String {
        val input = Scanner(System.`in`).nextLine()
        return if ((screenId != 1).and(screenId != 3)) {
            if(InputHandler.isDigit(input)) {
                if(InputHandler.isNumberInRange(input, lastBtnNumber)) {
                    input
                } else {
                    println("Ошибка! Такой цифры в списке нет, введите правильное значение")
                    "Input Error"
                }
            } else {
                println("Ошибка! Введите цифру")
                "Input Error"
            }
        } else {
            input
        }
    }

    fun showCreatorHeader(): Int {
        println("Введите название:")
        return 0
    }

    fun showChooseMessage() = println("\nВыберите один из пунктов и введите его номер:")

    fun showWriteTextMessage() = println("Введите текст заметки:")

}