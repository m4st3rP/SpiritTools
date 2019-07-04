package waffe

import com.beust.klaxon.Klaxon
import java.io.File

data class Teile(
    val eigenschaften: MutableList<Eigenschaft> = mutableListOf(),
    val feuermodi: MutableList<Feuermodus> = mutableListOf(),
    val kaliber: MutableList<Kaliber> = mutableListOf(),
    val laufarten: MutableList<Lauf> = mutableListOf(),
    val magazine: MutableList<Magazin> = mutableListOf(),
    val rahmen: MutableList<Rahmen> = mutableListOf(),
    val schaftarten: MutableList<Schaft> = mutableListOf(),
    val blacklists: MutableList<Blacklist> = mutableListOf(),
    val whitelists: MutableList<Whitelist> = mutableListOf()
) {
    init {
        val eigenschaftenPath = File(".\\JSON\\Eigenschaften")
        val feuermodiPath = File(".\\JSON\\Feuermodi")
        val kaliberPath = File(".\\JSON\\Kaliber")
        val laufartenPath = File(".\\JSON\\Laufarten")
        val magazinePath = File(".\\JSON\\Magazine")
        val rahmenPath = File(".\\JSON\\Rahmen")
        val schaftartenPath = File(".\\JSON\\Schaftarten")

        val blacklistsPath = File(".\\JSON\\Regeln\\Blacklists")
        val whitelistsPath = File(".\\JSON\\Regeln\\Whitelists")

        //TODO: fix parsing of special characters
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

        blacklistsPath.listFiles().forEach {
            Klaxon().parse<Blacklist>(it)?.let { it1 -> blacklists.add(it1) }
        }

        whitelistsPath.listFiles().forEach {
            Klaxon().parse<Whitelist>(it)?.let { it1 -> whitelists.add(it1) }
        }
    }
}