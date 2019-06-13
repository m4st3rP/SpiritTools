package waffen

import com.beust.klaxon.Klaxon
import java.io.File

fun main() {
    val eigenschaften = mutableListOf<Eigenschaft>()
    val feuermodi = mutableListOf<Feuermodus>()
    val kaliber = mutableListOf<Kaliber>()
    val laufarten = mutableListOf<Lauf>()
    val magazine = mutableListOf<Magazin>()
    val rahmen = mutableListOf<Rahmen>()
    val schaftarten = mutableListOf<Schaft>()

    val eigenschaftenPath = File(".\\src\\main\\resources\\JSON\\Eigenschaften")
    val feuermodiPath = File(".\\src\\main\\resources\\JSON\\Feuermodi")
    val kaliberPath = File(".\\src\\main\\resources\\JSON\\Kaliber")
    val laufartenPath = File(".\\src\\main\\resources\\JSON\\Laufarten")
    val magazinePath = File(".\\src\\main\\resources\\JSON\\Magazine")
    val rahmenPath = File(".\\src\\main\\resources\\JSON\\Rahmen")
    val schaftartenPath = File(".\\src\\main\\resources\\JSON\\Schaftarten")

    eigenschaftenPath.listFiles().forEach {
        Klaxon().parse<Eigenschaft>(it)?.let { it1 -> eigenschaften.add(it1) }
    }

    feuermodiPath.listFiles().forEach {
        Klaxon().parse<Feuermodus>(it)?.let { it1 -> feuermodi.add(it1) }
    }

    kaliberPath.listFiles().forEach {
        Klaxon().parse<Kaliber>(it)?.let { it1 -> kaliber.add(it1) }
    }

    laufartenPath.listFiles().forEach {
        Klaxon().parse<Lauf>(it)?.let { it1 -> laufarten.add(it1) }
    }

    magazinePath.listFiles().forEach {
        Klaxon().parse<Magazin>(it)?.let { it1 -> magazine.add(it1) }
    }

    rahmenPath.listFiles().forEach {
        Klaxon().parse<Rahmen>(it)?.let { it1 -> rahmen.add(it1) }
    }

    schaftartenPath.listFiles().forEach {
        Klaxon().parse<Schaft>(it)?.let { it1 -> schaftarten.add(it1) }
    }
}