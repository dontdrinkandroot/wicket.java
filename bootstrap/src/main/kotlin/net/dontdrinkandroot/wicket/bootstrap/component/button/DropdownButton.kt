package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class DropdownButton<T>(
    id: String,
    model: IModel<T>? = null,
    private var labelModel: IModel<String>?,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null),
) : GenericPanel<T>(id, model) {

    protected var buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    var iconBehavior = IconBehavior(prependIconModel, appendIconModel)
        protected set

    lateinit var toggle: Label
        private set

    lateinit var menu: DropdownMenu
        private set

    init {
        createComponents()
        add(CssClassAppender(BootstrapCssClass.DROPDOWN))
    }

    protected fun createComponents() {
        toggle = Label("toggle", labelModel)
        toggle.add(DropdownToggleBehavior())
        menu = createDropdownMenu("menu")
    }

    protected fun createDropdownMenu(id: String): DropdownMenu {
        return object : DropdownMenu(id) {
            override fun populateItems(itemView: RepeatingView) {
                this@DropdownButton.populateItems(itemView)
            }
        }
    }

    override fun onInitialize() {
        super.onInitialize()
        toggle.add(buttonBehavior)
        toggle.add(iconBehavior)
        this.add(toggle)
        this.add(menu)
    }

    fun setDropdownAlignment(alignment: DropdownAlignment): DropdownButton<T> {
        menu.setAlignment(alignment)
        return this
    }

    protected abstract fun populateItems(itemView: RepeatingView)
}