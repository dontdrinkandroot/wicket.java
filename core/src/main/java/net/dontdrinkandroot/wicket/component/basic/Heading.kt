package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label

class Heading(id: String, model: KModel<String>, private val headingLevelModel: KModel<Level>) : Label(id, model) {

    constructor(id: String, heading: String) : this(id, heading.kModel(), Level.H1.kModel())

    constructor(id: String, model: KModel<String>, headingLevel: Level) : this(id, model, headingLevel.kModel())

    constructor(id: String, heading: String, headingLevel: Level) : this(id, heading.kModel(), headingLevel.kModel())

    enum class Level {
        H1, H2, H3, H4, H5, H6
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = headingLevelModel.getValue().name.toLowerCase()
        super.onComponentTag(tag)
    }

    override fun detachModels() {
        super.detachModels()
        headingLevelModel.detach()
    }
}