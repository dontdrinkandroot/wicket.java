package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroupChoice
import net.dontdrinkandroot.wicket.bootstrap.component.button.DropdownButton
import net.dontdrinkandroot.wicket.bootstrap.component.button.SplitDropdownButton
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import java.util.*

class ButtonPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Buttons")

    override fun onInitialize() {
        super.onInitialize()

        val styleView = RepeatingView("buttonStyle")
        this.add(styleView)

        for (style in ButtonStyle.values()) {
            val button = Label(styleView.newChildId(), Model.of(style.name))
            button.add(ButtonBehavior(style))
            styleView.add(button)
        }

        val sizeView = RepeatingView("buttonSize")
        this.add(sizeView)

        for (size in ButtonSize.values()) {
            val button = Label(sizeView.newChildId(), Model.of(size.name))
            button.add(ButtonBehavior(size))
            sizeView.add(button)
        }

        val dropdownButton: DropdownButton<Void> =
            object : DropdownButton<Void>("dropdownButton", null, Model.of("My Label")) {
                override fun populateItems(itemView: RepeatingView) {
                    populateDropdownItems(itemView)
                }
            }
        this.add(dropdownButton)

        val dropupButton: DropdownButton<Void> =
            object : DropdownButton<Void>("dropupButton", null, Model.of("DropUp")) {
                override fun populateItems(itemView: RepeatingView) {
                    populateDropdownItems(itemView)
                }
            }
        dropupButton.add(CssClassAppender(BootstrapCssClass.DROPUP))
        this.add(dropupButton)

        val splitDropdownButton: SplitDropdownButton<Void> = object : SplitDropdownButton<Void>("splitDropdownButton") {
            override fun createAction(id: String): Component {
                return Label(id, "Action")
            }

            override fun populateItems(itemView: RepeatingView) {
                populateDropdownItems(itemView)
            }
        }
        this.add(splitDropdownButton)

        val choices = Arrays.asList("Red", "Green", "Blue")
        val buttonGroupChoice = ButtonGroupChoice("buttonGroupChoice", Model.of(choices.iterator().next()), choices)
        this.add(buttonGroupChoice)
    }

    protected fun populateDropdownItems(itemView: RepeatingView) {
        itemView.add(
            BookmarkablePageLinkItem<Void>(
                itemView.newChildId(),
                labelModel = Model("This is a link"),
                pageClass = ButtonPage::class.java
            )
        )
    }
}