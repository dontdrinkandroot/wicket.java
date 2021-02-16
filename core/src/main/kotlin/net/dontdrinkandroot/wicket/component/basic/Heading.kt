package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class Heading(id: String, model: IModel<String>, private val headingLevelModel: IModel<Level> = Level.H1.model()) :
    Label(id, model) {

    constructor(id: String, heading: String) : this(id, heading.model(), Level.H1.model())

    constructor(id: String, model: IModel<String>, headingLevel: Level) : this(id, model, headingLevel.model())

    constructor(id: String, heading: String, headingLevel: Level) : this(id, heading.model(), headingLevel.model())

    enum class Level {
        H1, H2, H3, H4, H5, H6
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = headingLevelModel.getObject().name.toLowerCase()
        super.onComponentTag(tag)
    }

    override fun detachModels() {
        super.detachModels()
        headingLevelModel.detach()
    }
}