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

abstract class SplitDropdownButton<T> : GenericPanel<T>, IButton {

    private val buttonBehavior = ButtonBehavior()

    lateinit var toggle: WebMarkupContainer
        private set

    constructor(id: String) : super(id)

    constructor(id: String, model: IModel<T>) : super(id, model)

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.BTN_GROUP))
        val action = createAction("button")
        action.add(buttonBehavior)
        this.add(action)
        toggle = WebMarkupContainer("toggle")
        toggle.add(buttonBehavior)
        toggle.add(DropdownToggleBehavior())
        toggle.add(IconBehavior().setAppendIcon(caretClass).setSeparator(null))
        this.add(toggle)
        this.add(createDropdownMenu("dropdownMenu"))
    }

    protected fun createDropdownMenu(id: String?): Component {
        return object : DropdownMenu(id!!) {
            override fun populateItems(itemView: RepeatingView) {
                this@SplitDropdownButton.populateItems(itemView)
            }
        }
    }

    override fun getButtonSize(): ButtonSize? {
        return buttonBehavior.getButtonSize()
    }

    override fun setButtonSize(buttonSize: ButtonSize?): SplitDropdownButton<T> {
        buttonBehavior.setButtonSize(buttonSize)
        return this
    }

    override fun getButtonStyle(): ButtonStyle {
        return buttonBehavior.getButtonStyle()
    }

    override fun setButtonStyle(buttonStyle: ButtonStyle): SplitDropdownButton<T> {
        buttonBehavior.setButtonStyle(buttonStyle)
        return this
    }

    override fun setButtonSizeModel(buttonSizeModel: IModel<ButtonSize>): SplitDropdownButton<T> {
        buttonBehavior.setButtonSizeModel(buttonSizeModel)
        return this
    }

    override fun setButtonStyleModel(buttonStyleModel: IModel<ButtonStyle>): SplitDropdownButton<T> {
        buttonBehavior.setButtonStyleModel(buttonStyleModel)
        return this
    }

    protected val caretClass: BootstrapCssClass
        protected get() = BootstrapCssClass.CARET

    protected abstract fun createAction(id: String): Component

    protected abstract fun populateItems(itemView: RepeatingView)
}