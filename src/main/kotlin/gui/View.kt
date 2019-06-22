package gui

import tornadofx.*
import tornadofx.View

class View : View("Spirit Tools") {
    private val controller = Controller()

    override val root = vbox {
        gridpane {
            row {
                listview(controller.getRahmen())
                listview(controller.getKaliber())
                listview(controller.getFeuermodi())
                listview(controller.getMagazine())
            }
            row {
                listview(controller.getLaufarten())
                listview(controller.getSchaftarten())
                listview(controller.getEigenschaftenVorteilig())
                listview(controller.getEigenschaftenNachteilig())
            }
        }
        label { text = "Waffenwerte" }
    }
}