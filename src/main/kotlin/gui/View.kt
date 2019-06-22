package gui

import javafx.event.EventHandler
import javafx.scene.control.SelectionMode
import javafx.scene.control.TableView
import tornadofx.*
import tornadofx.View
import waffe.*

class View : View("Spirit Tools") {
    private val controller = Controller()

    private var rahmenTable: TableView<Rahmen>? = null
    private var kaliberTable: TableView<Kaliber>? = null
    private var feuermodiTable: TableView<Feuermodus>? = null
    private var magazinTable: TableView<Magazin>? = null

    private var laufTable: TableView<Lauf>? = null
    private var schaftTable: TableView<Schaft>? = null
    private var eigenschaftVorteiligTable: TableView<Eigenschaft>? = null
    private var eigenschaftNachteiligTable: TableView<Eigenschaft>? = null

    //private var waffenTable: TableView<Waffe>? = null

    override val root = vbox {
        tabpane {
            tab("Rahmen") {
                rahmenTable = tableview(controller.getRahmen()) {
                    readonlyColumn("Name", Rahmen::name)
                    readonlyColumn("Last", Rahmen::last)
                    readonlyColumn("Rückstoß", Rahmen::rueckstoss)
                    readonlyColumn("Komplexität", Rahmen::komplexitaet)
                    readonlyColumn("Punkte", Rahmen::punkte)
                    readonlyColumn("Preis", Rahmen::preis)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
            tab("Kaliber") {
                kaliberTable = tableview(controller.getKaliber()) {
                    readonlyColumn("Name", Kaliber::name)
                    readonlyColumn("Last", Kaliber::last)
                    readonlyColumn("Kugeln", Kaliber::schadenAnzahl)
                    readonlyColumn("Schaden", Kaliber::schaden)
                    readonlyColumn("Durchschlag", Kaliber::durchschlag)
                    readonlyColumn("Durchschlag = 0?", Kaliber::durchschlagNull)
                    readonlyColumn("Reichweite", Kaliber::reichweite)
                    readonlyColumn("Rückstoß", Kaliber::rueckstoss)
                    readonlyColumn("Komplexität", Kaliber::komplexitaet)
                    readonlyColumn("Punkte", Kaliber::punkte)
                    readonlyColumn("Preis", Kaliber::preis)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
            tab("Feuermodus") {
                feuermodiTable = tableview(controller.getFeuermodi()) {
                    readonlyColumn("Name", Feuermodus::name)
                    readonlyColumn("Reichweite", Feuermodus::reichweite)
                    readonlyColumn("Rückstoß", Feuermodus::rueckstoss)
                    readonlyColumn("Komplexität", Feuermodus::komplexitaet)
                    readonlyColumn("Punkte", Feuermodus::punkte)
                    readonlyColumn("Preismodifikator", Feuermodus::preisModifikator)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
            tab("Magazin") {
                magazinTable = tableview(controller.getMagazine()) {
                    readonlyColumn("Name", Magazin::name)
                    readonlyColumn("Durchschlag", Magazin::durchschlag)
                    readonlyColumn("Komplexität", Magazin::komplexitaet)
                    readonlyColumn("Punkte", Magazin::punkte)
                    readonlyColumn("Preismodifikator", Magazin::preisModifikator)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
            tab("Lauf") {
                laufTable = tableview(controller.getLaufarten()) {
                    readonlyColumn("Name", Lauf::name)
                    readonlyColumn("Last", Lauf::last)
                    readonlyColumn("Durchschlag", Lauf::durchschlag)
                    readonlyColumn("Reichweitenmodifikator", Lauf::reichweitenModifikator)
                    readonlyColumn("Rückstoß", Lauf::rueckstoss)
                    readonlyColumn("Punkte", Lauf::punkte)
                    readonlyColumn("Preismodifikator", Lauf::preisModifikator)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
            tab("Schaft") {
                schaftTable = tableview(controller.getSchaftarten()) {
                    readonlyColumn("Name", Schaft::name)
                    readonlyColumn("Last", Schaft::last)
                    readonlyColumn("Reichweite", Schaft::reichweite)
                    readonlyColumn("Rückstoßmodifikator", Schaft::rueckstossModifikator)
                    readonlyColumn("Punkte", Schaft::punkte)
                    readonlyColumn("Preismodifikator", Schaft::preisModifikator)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
            }
                /*eigenschaftVorteiligTable = tableview(controller.getEigenschaftenVorteilig()) {
                    readonlyColumn("Name", Rahmen::name)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }
                eigenschaftNachteiligTable = tableview(controller.getEigenschaftenNachteilig()) {
                    readonlyColumn("Name", Rahmen::name)
                    selectionModel.selectionMode = SelectionMode.SINGLE
                }*/
        }
        val waffenTable = tableview<Waffe> {
            readonlyColumn("Punkte", Waffe::punkteE)
            readonlyColumn("Kugeln", Waffe::kugelnE)
            readonlyColumn("Schaden", Waffe::schadenE)
            readonlyColumn("DS", Waffe::durchschlagE)
            readonlyColumn("RS", Waffe::rueckstossE)
            readonlyColumn("RW", Waffe::reichweiteE)
            readonlyColumn("Kal", Waffe::kaliberE)
            readonlyColumn("Magart", Waffe::magazinartE)
            readonlyColumn("Maggröße", Waffe::magazingroesseE)
            readonlyColumn("Modus", Waffe::feuermodusE)
            readonlyColumn("Last", Waffe::lastE)
            readonlyColumn("Kompl.", Waffe::komplexitaetE)
            readonlyColumn("Eigen.", Waffe::eigenschaftenNamenE)
            readonlyColumn("Preis", Waffe::preisE)

            readonlyColumn("Angriffbonus", Waffe::schwierigkeitDesAngriffBonusE)
            readonlyColumn("Einklapp.", Waffe::einklappbarE)
            readonlyColumn("Vollautosalvenkugeln", Waffe::vollautomatischeSalvenKugelanzahlE)
            readonlyColumn("Schalldämpfer", Waffe::schalldaempferE)
            readonlyColumn("Repetieren ist freie Handlung", Waffe::repetierenIstFreieHandlungE)
            readonlyColumn("Wartungs-/Reperaturbonus", Waffe::wartungsReperaturBonusE)
            readonlyColumn("Läufe", Waffe::laeufeAnzahlE)
            readonlyColumn("Ladehemmungen bei Patzer", Waffe::ladehemmungenE)
            readonlyColumn("Spezialmag.", Waffe::spezialmagazinE)
            readonlyColumn("Robust", Waffe::robustE)
            readonlyColumn("Unrobust", Waffe::unrobustE)
            readonlyColumn("PING!", Waffe::geraeuschBeimNachladenE)

            selectionModel.selectionMode = SelectionMode.SINGLE
        }
        button("Waffe zusammenstellen").onAction = EventHandler {
            val feuermodus = feuermodiTable?.selectionModel?.selectedItem
            val kaliber = kaliberTable?.selectionModel?.selectedItem
            val lauf = laufTable?.selectionModel?.selectedItem
            val magazin = magazinTable?.selectionModel?.selectedItem
            val rahmen = rahmenTable?.selectionModel?.selectedItem
            val schaft = schaftTable?.selectionModel?.selectedItem

            val waffe = controller.getWaffe(listOf(), feuermodus!!, kaliber!!, lauf!!, magazin!!, rahmen!!, schaft!!) //TODO: do proper checks
            waffe.calculateEverything()
            if (waffe.getWaffeLegal(controller.teile.blacklists, controller.teile.whitelists).legal) {
                waffenTable.items.add(waffe)
            } else {
                //TODO: message that waffe is not legal
            }
        }
    }
}