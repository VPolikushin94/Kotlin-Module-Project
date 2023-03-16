class Menu {

    fun addBtn(screenId: Int) {
        Navigator.nextScreen(screenId)
    }

    fun goBackBtn() {
        Navigator.goBack()
    }

    fun selectItemBtn(screenId: Int, selectedItem: Int) {
        Navigator.nextScreen(screenId, selectedItem)
    }
}