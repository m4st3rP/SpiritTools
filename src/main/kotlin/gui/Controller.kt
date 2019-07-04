package gui

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.App
import waffe.*

class Controller: App(View::class, Styles::class) {
    val teile = Teile()

    fun getRahmen(): ObservableList<Rahmen>? = FXCollections.observableArrayList(teile.rahmen)
    fun getKaliber(): ObservableList<Kaliber>? = FXCollections.observableArrayList(teile.kaliber)
    fun getFeuermodi(): ObservableList<Feuermodus>? = FXCollections.observableArrayList(teile.feuermodi)
    fun getMagazine(): ObservableList<Magazin>? = FXCollections.observableArrayList(teile.magazine)
    fun getLaufarten(): ObservableList<Lauf>? = FXCollections.observableArrayList(teile.laufarten)
    fun getSchaftarten(): ObservableList<Schaft>? = FXCollections.observableArrayList(teile.schaftarten)
    fun getEigenschaften(): ObservableList<Eigenschaft>? = FXCollections.observableArrayList(teile.eigenschaften)

    fun getEigenschaftenVorteilig(): ObservableList<Eigenschaft>? = FXCollections.observableArrayList(teile.eigenschaften.filter { it.vorteil })
    fun getEigenschaftenNachteilig(): ObservableList<Eigenschaft>? = FXCollections.observableArrayList(teile.eigenschaften.filter { !it.vorteil })

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