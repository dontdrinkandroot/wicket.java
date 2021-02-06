package net.dontdrinkandroot.wicket.example.model

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BOOTSTRAP_VERSION
import java.io.Serializable

fun availableThemes(): List<Theme> {
    val availableThemes = mutableListOf<Theme>()
    availableThemes.add(
        Theme(
            "Vanilla",
            "https://cdn.jsdelivr.net/npm/bootstrap@$BOOTSTRAP_VERSION/dist/css/bootstrap.min.css"
        )
    )
    listOf(
        "Cerulean",
        "Cosmo",
        "Cyborg",
        "Darkly",
        "Flatly",
        "Journal",
        "Litera",
        "Lumen",
        "LUX",
        "Materia",
        "Minty",
        "Pulse",
        "Sandstone",
        "Simplex",
        "Sketchy",
        "Slate",
        "Solar",
        "Spacelab",
        "Superhero",
        "United",
        "Yeti"
    ).forEach { name ->
        val url =
            "https://maxcdn.bootstrapcdn.com/bootswatch/$BOOTSTRAP_VERSION/${name.toLowerCase()}/bootstrap.min.css"
        availableThemes.add(Theme(name, url))
    }

    return availableThemes
}

class Theme(val name: String, val url: String) : Serializable