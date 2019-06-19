package waffen

data class Magazin(
    val name: String,
    val durchschlag: Int,
    val komplexitaet: Int,
    val punkte: Int,
    val preisModifikator: Double
)