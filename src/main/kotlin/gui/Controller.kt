package gui

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.App
import waffe.*

class Controller: App(View::class, Styles::class) {
    private val model = Model()

    fun getRahmen(): ObservableList<Rahmen>? = FXCollections.observableArrayList(model.teile.rahmen)
    fun getKaliber(): ObservableList<Kaliber>? = FXCollections.observableArrayList(model.teile.kaliber)
    fun getFeuermodi(): ObservableList<Feuermodus>? = FXCollections.observableArrayList(model.teile.feuermodi)
    fun getMagazine(): ObservableList<Magazin>? = FXCollections.observableArrayList(model.teile.magazine)
    fun getLaufarten(): ObservableList<Lauf>? = FXCollections.observableArrayList(model.teile.laufarten)
    fun getSchaftarten(): ObservableList<Schaft>? = FXCollections.observableArrayList(model.teile.schaftarten)
    fun getEigenschaftenVorteilig(): ObservableList<Eigenschaft>? = FXCollections.observableArrayList(model.teile.eigenschaften.filter { it.vorteil })
    fun getEigenschaftenNachteilig(): ObservableList<Eigenschaft>? = FXCollections.observableArrayList(model.teile.eigenschaften.filter { !it.vorteil })

    fun getWaffe(
        eigenschaften: List<Eigenschaft>,
        feuermodus: Feuermodus,
        kaliber: Kaliber,
        lauf: Lauf,
        magazin: Magazin,
        rahmen: Rahmen,
        schaft: Schaft
    ): Waffe {
        return Waffe(eigenschaften, feuermodus, kaliber, lauf, magazin, rahmen, schaft)
    }
}