package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.component.basic.Heading.Level.H1
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class Heading(id: String, model: IModel<String>, private val headingLevelModel: IModel<Level> = Model(H1)) :
    Label(id, model) {

    constructor(id: String, heading: String) : this(id, Model(heading), Model(H1))

    constructor(id: String, model: IModel<String>, headingLevel: Level) : this(id, model, Model(headingLevel))

    constructor(id: String, heading: String, headingLevel: Level) : this(id, Model(heading), Model(headingLevel))

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