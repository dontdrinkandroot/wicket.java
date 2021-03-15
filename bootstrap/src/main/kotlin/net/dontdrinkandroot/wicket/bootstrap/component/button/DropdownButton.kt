package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.addCssClass
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.dropdownToggle
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.markup.html.basic.label
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class DropdownButton<T>(
    id: String,
    model: IModel<T>? = null,
    private var label: IModel<String>?,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null),
    private val dropdownAlignmentModel: IModel<DropdownAlignment?> = Model(null),
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
        addCssClass(BootstrapCssClass.DROPDOWN)
    }

    protected fun createComponents() {
        toggle = label("toggle", label, dropdownToggle())
        menu = createDropdownMenu("menu")
    }

    protected fun createDropdownMenu(id: String) = object : DropdownMenu(id, dropdownAlignmentModel) {
        override fun populateItems(itemView: ItemView) {
            this@DropdownButton.populateItems(itemView)
        }
    }

    override fun onInitialize() {
        super.onInitialize()
        toggle.add(buttonBehavior)
        toggle.add(iconBehavior)
        this.add(toggle)
        this.add(menu)
    }

    protected abstract fun populateItems(itemView: ItemView)
}