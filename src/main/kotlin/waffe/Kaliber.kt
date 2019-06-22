package waffe

data class Kaliber(
    val name: String,
    val last: Int,
    val schadenAnzahl: Int,
    val schaden: Int,
    val durchschlag: Int,
    val durchschlagNull: Boolean,
    val reichweite: Int,
    val rueckstoss: Int,
    val komplexitaet: Int,
    val punkte: Int,
    val preis: Double
)