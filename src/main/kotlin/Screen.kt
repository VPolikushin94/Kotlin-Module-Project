class Screen(val screenId: Int, val selectedItem: Int? = null) {

    private val menu = Menu()

    init {
        showContent()
    }

    private fun showContent() {
        UserDialog.showScreenName(screenId)

        if((screenId == 0).or(screenId == 2)) {
            UserDialog.showAddBtn()
        }
        val contentSize = when(screenId) {
            0 -> UserDialog.showScreenContent(Data.archiveList)
            1 -> UserDialog.showCreatorHeader()
            2 -> UserDialog.showScreenContent(Data.archiveList[selectedItem!!].noteList)
            else -> 0
        }
        if((screenId == 0).or(screenId == 2)) {
            UserDialog.showBackBtn(contentSize)
        }

        getUsersChoice(contentSize)
    }

    private fun getUsersChoice(contentSize: Int) {
        val input = UserDialog.readInput()

        when(screenId) {
            0, 2 -> clickMenuBtn(input, contentSize)
            1 -> {
                Data.archiveList.add(Archive(input, mutableListOf()))
                menu.goBackBtn()
            }
            3 -> {
                Data.archiveList[selectedItem!!].noteList.add(Note(input, ""))
                menu.goBackBtn()
            }
        }
    }

    private fun clickMenuBtn(input: String, contentSize: Int) {
        when(val inputInt = input.toInt()) {
            0 -> menu.addBtn(screenId + 1)
            contentSize + 1 -> menu.goBackBtn()
            else -> menu.selectItemBtn(2, inputInt - 1)
        }
    }
}