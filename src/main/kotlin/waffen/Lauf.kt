package waffen

data class Lauf(val name: String,
                val last: Int,
                val durchschlag: Int,
                val reichweitenModifikator: Double,
                val rueckstoss: Int,
                val punkte: Int,
                val preisModifikator: Double) {
}