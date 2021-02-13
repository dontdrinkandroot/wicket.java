package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.*
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome4IconClass
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import net.dontdrinkandroot.wicket.example.page.DecoratorPage
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.model.util.ListModel
import org.apache.wicket.request.mapper.parameter.PageParameters
import java.time.LocalDate
import java.util.*

abstract class FormPage(parameters: PageParameters) : DecoratorPage<Void>(parameters) {

    override fun createPageTitlePrefixModel() =
        ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", "Forms".model())

    protected fun populateFormGroups(form: Form<Void>, formGroupView: RepeatingView) {
        val choices = Arrays.asList("Apple", "Banana", "Pear")

        val formGroupStatic = FormGroupStatic(
            formGroupView.newChildId(),
            FormGroupStatic::class.java.simpleName.model(),
            Model.of("A static label")
        )
        formGroupView.add(formGroupStatic)

        val formGroupTextField = FormGroupInputText(
            formGroupView.newChildId(),
            FormGroupInputText::class.java.simpleName.model(),
            Model.of("")
        )
        formGroupTextField.formComponent.isRequired = true
        formGroupTextField.addAjaxValidation("input")
        formGroupTextField.setHelpText("A help text")
        formGroupView.add(formGroupTextField)

        val formGroupPasswordTextField = FormGroupInputPassword(
            formGroupView.newChildId(),
            FormGroupInputPassword::class.java.simpleName.model(),
            Model.of("")
        )
        formGroupView.add(formGroupPasswordTextField)

        val formGroupEmailTextField = FormGroupInputEmail(
            formGroupView.newChildId(),
            FormGroupInputEmail::class.java.simpleName.model(),
            Model.of("")
        )
        formGroupView.add(formGroupEmailTextField)

        val formGroupUrlTextField = FormGroupInputUrl(
            formGroupView.newChildId(),
            FormGroupInputUrl::class.java.simpleName.model(),
            Model.of("")
        )
        formGroupView.add(formGroupUrlTextField)

        val formGroupTextArea = FormGroupTextArea(
            formGroupView.newChildId(),
            FormGroupTextArea::class.java.simpleName.model(),
            Model.of("")
        )
        formGroupTextArea.setRequired(true)
        formGroupView.add(formGroupTextArea)

        val formGroupLocalDate: FormGroupLocalDate = object : FormGroupLocalDate(
            formGroupView.newChildId(),
            FormGroupLocalDate::class.java.simpleName.model(),
            Model.of(LocalDate.now())
        ) {
            override fun createInputGroupAppend(id: String): Component {
                val after = InputGroupLabel(id)
                after.add(IconBehavior(FontAwesome4IconClass.CALENDAR_O.createIcon()))
                return after
            }
        }
        formGroupLocalDate.formComponent.setMin(LocalDate.now().withMonth(1).withDayOfMonth(1))
        formGroupLocalDate.formComponent.setMax(LocalDate.now().withMonth(12).withDayOfMonth(31))
        formGroupView.add(formGroupLocalDate)

        val formGroupLocalTime = FormGroupLocalTime(
            formGroupView.newChildId(),
            FormGroupLocalTime::class.java.simpleName.model(),
            Model()
        )
        formGroupView.add(formGroupLocalTime)

        val formGroupLocalDateTime = FormGroupLocalDateTime(
            formGroupView.newChildId(),
            FormGroupLocalDateTime::class.java.simpleName.model(),
            Model()
        )
        formGroupView.add(formGroupLocalDateTime)

        val formGroupCheckBox = FormGroupCheckBox(
            formGroupView.newChildId(),
            FormGroupCheckBox::class.java.simpleName.model(),
            Model()
        )
        formGroupView.add(formGroupCheckBox)

        val formGroupRadioChoice = FormGroupRadioChoice(
            formGroupView.newChildId(),
            FormGroupRadioChoice::class.java.simpleName.model(),
            Model.of(""),
            choices
        )
        formGroupView.add(formGroupRadioChoice)

        val formGroupSelect = FormGroupSelect(
            formGroupView.newChildId(),
            FormGroupSelect::class.java.simpleName.model(),
            Model.of(""),
            choices
        )
        formGroupSelect.setRequired(false)
        formGroupSelect.setNullValid(true)
        formGroupView.add(formGroupSelect)

        val formGroupInputFile = FormGroupInputFile(
            formGroupView.newChildId(),
            FormGroupInputFile::class.java.simpleName.model(),
            ListModel()
        )
        formGroupView.add(formGroupInputFile)

        val formGroupActions: FormGroupActions<Void> = object : FormGroupActions<Void>(formGroupView.newChildId()) {
            override fun populateActions(actionView: RepeatingView) {
                val submitButton = AjaxSubmitButton(actionView.newChildId())
                submitButton.body = Model.of("Submit")
                actionView.add(submitButton)
                val cancelButton = Label(actionView.newChildId(), "Cancel")
                cancelButton.add(ButtonBehavior())
                actionView.add(cancelButton)
            }
        }
        formGroupView.add(formGroupActions)

        formGroupView.forEach { it.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL)) }
    }
}