package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class SplitDropdownButton<T>(
    id: String,
    model: IModel<T>? = null,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
) : GenericPanel<T>(id, model) {

    private val buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    lateinit var toggle: WebMarkupContainer
        private set

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.BTN_GROUP))
        val action = createAction("button")
        action.add(buttonBehavior)
        this.add(action)
        toggle = WebMarkupContainer("toggle")
        toggle.add(buttonBehavior)
        toggle.add(DropdownToggleBehavior())
        this.add(toggle)
        this.add(createDropdownMenu("dropdownMenu"))
    }

    protected fun createDropdownMenu(id: String): Component {
        return object : DropdownMenu(id) {
            override fun populateItems(itemView: RepeatingView) {
                this@SplitDropdownButton.populateItems(itemView)
            }
        }
    }

    protected abstract fun createAction(id: String): Component

    protected abstract fun populateItems(itemView: RepeatingView)
}