class Screen(
    private val screenId: Int,
    private val selectedArchiveIndex: Int? = null,
    private val selectedNoteIndex: Int? = null
) {

    private val menu = Menu()

    init {
        showContent()
    }

    private fun showContent() {
        val screenName = getScreenName()
        UserDialog.showScreenName(screenId, screenName)

        if((screenId == 0).or(screenId == 2).or(screenId == 4)) {
            UserDialog.showFirstBtn(screenId)
        }
        val contentSize = when(screenId) {
            0 -> UserDialog.showScreenContent(Data.archiveList)
            1, 3 -> UserDialog.showCreatorHeader()
            2 -> UserDialog.showScreenContent(Data.archiveList[selectedArchiveIndex!!].noteList)
            5 -> UserDialog.showNote(Data.archiveList[selectedArchiveIndex!!]
                .noteList[selectedNoteIndex!!].text)
            else -> 0
        }
        if(
            (screenId == 0).or(screenId == 2).or(screenId == 4).or(screenId == 5)
        ) {
            UserDialog.showBackBtn(contentSize)
            UserDialog.showChooseMessage()
        }

        getUsersChoice(contentSize)
    }

    private fun getUsersChoice(contentSize: Int) {
        val input = UserDialog.readInput()

        when(screenId) {
            0, 2, 4 -> clickMenuBtn(input, contentSize)
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
                    0 -> menu.firstBtn(screenId + 1)
                    2 -> menu.firstBtn(screenId + 1, selectedArchiveIndex!!)
                    4 -> menu.firstBtn(screenId + 1, selectedArchiveIndex!!, selectedNoteIndex!!)
                }
            }
            contentSize + 1 -> menu.goBackBtn()
            else -> {
                if(selectedArchiveIndex != null)  {
                    menu.selectItemBtn(screenId + 2, selectedArchiveIndex,inputInt - 1)
                } else {
                    menu.selectItemBtn(screenId + 2, inputInt - 1)
                }
            }
        }
    }

    private fun getScreenName(): String {
        return if(selectedArchiveIndex != null) {
            if (selectedNoteIndex != null) {
                Data.archiveList[selectedArchiveIndex].noteList[selectedNoteIndex].name
            } else {
                Data.archiveList[selectedArchiveIndex].name
            }
        } else {
            ""
        }
    }
}