import waffen.Teile
import waffen.Waffe

fun main() {
    val teile = Teile()
    //testEigenschaftenVorteilNachteilPunkte(teile)
    testWaffe1()
}

fun testEigenschaftenVorteilNachteilPunkte(teile: Teile) {
    val iterator = teile.eigenschaften.iterator()

    iterator.forEach {
        if(it.vorteil && (it.punkte > 0)) {
            println("${it.name} punkte are wrong")
        }

        if(!it.vorteil && (it.punkte < 0)) {
            println("${it.name} punkte are wrong")
        }
    }
}

fun testWaffe1() {
    val teile = Teile()
    val waffe = Waffe(mutableListOf(), teile.feuermodi[1], teile.kaliber[0], teile.laufarten[0], teile.magazine[1], teile.rahmen[0], teile.schaftarten[0])
    assert(waffe.getLast() == 9)
    assert(waffe.getSchaden() == 6)
    assert(waffe.getDurchschlag() == 1)
    assert(waffe.getReichweite() == 50)
    assert(waffe.getRueckstoss() == 4)
    assert(waffe.getKomplexitaet() == 6)
    assert(waffe.getPunkte() == 3)
    assert(waffe.getPreis() == 153.9)
    println("done")
}