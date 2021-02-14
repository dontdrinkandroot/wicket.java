package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.MarkupStream
import org.apache.wicket.markup.html.WebComponent
import org.apache.wicket.markup.parser.XmlTag
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import java.io.Serializable

class ToStringLabel<T : Serializable>(id: String, model: IModel<T>? = null) : WebComponent(id, model) {
    constructor(id: String, label: T) : this(id, Model(label))

    /**
     * {@inheritDoc}
     */
    override fun onComponentTagBody(markupStream: MarkupStream, openTag: ComponentTag) {
        replaceComponentTagBody(markupStream, openTag, this.defaultModelObjectAsString)
    }

    /**
     * {@inheritDoc}
     */
    override fun onComponentTag(tag: ComponentTag) {
        super.onComponentTag(tag)
        if (tag.isOpenClose) {
            // always transform the tag to <span></span> so even labels defined as <span/> render
            tag.type = XmlTag.TagType.OPEN
        }
    }
}