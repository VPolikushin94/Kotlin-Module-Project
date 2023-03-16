class Screen(private val screenId: Int, private val selectedArchiveIndex: Int? = null) {

    private val menu = Menu()

    init {
        showContent()
    }

    private fun showContent() {
        val archiveName = getArchiveName()
        UserDialog.showScreenName(screenId, archiveName)

        if((screenId == 0).or(screenId == 2)) {
            UserDialog.showAddBtn(screenId)
        }
        val contentSize = when(screenId) {
            0 -> UserDialog.showScreenContent(Data.archiveList)
            1, 3 -> UserDialog.showCreatorHeader()
            2 -> UserDialog.showScreenContent(Data.archiveList[selectedArchiveIndex!!].noteList)
            else -> 0
        }
        if((screenId == 0).or(screenId == 2)) {
            UserDialog.showBackBtn(contentSize)
            UserDialog.showChooseMessage()
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
                UserDialog.showWriteTextMessage()
                val text = UserDialog.readInput()
                Data.archiveList[selectedArchiveIndex!!].noteList.add(Note(input, text))
                menu.goBackBtn(selectedArchiveIndex)
            }
        }
    }

    private fun clickMenuBtn(input: String, contentSize: Int) {
        when(val inputInt = input.toInt()) {
            0 -> {
                when(screenId) {
                    0 -> menu.addBtn(screenId + 1)
                    2 -> menu.addBtn(screenId + 1, selectedArchiveIndex!!)
                }
            }
            contentSize + 1 -> menu.goBackBtn()
            else -> menu.selectItemBtn(2, inputInt - 1)
        }
    }

    private fun getArchiveName(): String {
        return if(selectedArchiveIndex != null) {
            Data.archiveList[selectedArchiveIndex].name
        } else {
            ""
        }
    }
}