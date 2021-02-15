package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel
import java.time.Duration

abstract class FormGroupAutoComplete(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroupFormComponent<String, String, TextField<String>>(id, model, labelModel) {

    private lateinit var dropDownMenu: WebMarkupContainer

    private lateinit var suggestionView: ListView<String>

    override fun createComponents() {
        super.createComponents()
        dropDownMenu = WebMarkupContainer("dropdownMenu")
        dropDownMenu.outputMarkupId = true
        this.add(dropDownMenu)
        val suggestionsModel: IModel<List<String>> = object : LoadableDetachableModel<List<String>>() {
            override fun load(): List<String> {
                return getChoices(formComponent.input)
            }
        }
        suggestionView = object : ListView<String>("suggestionItem", suggestionsModel) {
            override fun populateItem(item: ListItem<String?>) {
                val link: AjaxLink<String> = object : AjaxLink<String>("link", item.model) {
                    override fun onClick(target: AjaxRequestTarget) {
                        this@FormGroupAutoComplete.model.setObject(this.modelObject)
                        target.add(formComponent)
                        target.add(dropDownMenu)
                    }
                }
                link.body = link.model
                item.add(link)
            }
        }
        dropDownMenu.add(suggestionView)
    }

    override fun addComponents() {
        super.addComponents()
        container.add(dropDownMenu)
        dropDownMenu.add(suggestionView)
    }

    override fun addBehaviors() {
        super.addBehaviors()
        this.add(CssClassAppender(BootstrapCssClass.DROPDOWN))
        this.add(CssClassAppender("autocomplete"))
        formComponent.add(DropdownToggleBehavior())
        formComponent.add(object : AjaxFormComponentUpdatingBehavior("input") {
            override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
                super.updateAjaxAttributes(attributes)
                attributes.throttlingSettings = ThrottlingSettings(Duration.ofMillis(250), true)
            }

            override fun onUpdate(target: AjaxRequestTarget) {
                target.add(dropDownMenu)
            }

            override fun onError(target: AjaxRequestTarget, e: RuntimeException) {
                super.onError(target, e)
                target.add(dropDownMenu)
            }
        })
    }

    override fun createFormComponent(id: String): TextField<String> = TextField(id, this.model)

    protected abstract fun getChoices(input: String?): List<String>
}