package waffen

import com.beust.klaxon.Klaxon
import java.io.File

class Waffe(val name: String,
            val last: Int,
            val schadenAnzahl: Int,
            val schadenMenge: Int,
            val durchschlag: Int,
            val reichweite: Int,
            val rueckstoss: Int,
            val magazin: Magazin,
            val magazingroesse: Int,
            val kaliber: Kaliber,
            val komplexitaet: Int,
            val preis: Double,
            val Eigenschaft: List<Eigenschaft>) {

}

fun main() {
    val file = File(".\\src\\main\\kotlin\\waffen\\JSONSchaftarten\\FesterSchaft.json")
    val schaft = Klaxon().parse<Schaft>(file)
    println("done")
}