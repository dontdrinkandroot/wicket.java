package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.*
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextLabel
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome4IconClass
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import net.dontdrinkandroot.wicket.example.page.DecoratorPage
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
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
        ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", Model("Forms"))

    protected fun populateFormGroups(form: Form<Void>, formGroupView: RepeatingView) {
        val choices = Arrays.asList("Apple", "Banana", "Pear")

        val formGroupStatic = FormGroupStatic(
            formGroupView.newChildId(),
            Model.of("A static label"),
            Model(FormGroupStatic::class.java.simpleName)
        )
        formGroupView.add(formGroupStatic)

        val formGroupTextField = FormGroupInputText(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupInputText::class.java.simpleName)
        )
        formGroupTextField.formComponent.isRequired = true
        formGroupTextField.addAjaxValidation("input")
        formGroupTextField.setHelpText("A help text")
        formGroupView.add(formGroupTextField)

        val formGroupPasswordTextField = FormGroupInputPassword(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupInputPassword::class.java.simpleName)
        )
        formGroupView.add(formGroupPasswordTextField)

        val formGroupEmailTextField = FormGroupInputEmail(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupInputEmail::class.java.simpleName)
        )
        formGroupView.add(formGroupEmailTextField)

        val formGroupUrlTextField = FormGroupInputUrl(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupInputUrl::class.java.simpleName)
        )
        formGroupView.add(formGroupUrlTextField)

        val formGroupTextArea = FormGroupTextArea(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupTextArea::class.java.simpleName)
        )
        formGroupTextArea.setRequired(true)
        formGroupView.add(formGroupTextArea)

        val formGroupLocalDate: FormGroupLocalDate = object : FormGroupLocalDate(
            formGroupView.newChildId(),
            Model.of(LocalDate.now()),
            Model(FormGroupLocalDate::class.java.simpleName)
        ) {
            override fun createInputGroupAppend(id: String): Component {
                val after = InputGroupTextLabel(id)
                after.add(IconBehavior(FontAwesome4IconClass.CALENDAR_O.createIcon()))
                return after
            }
        }
        formGroupLocalDate.formComponent.setMin(LocalDate.now().withMonth(1).withDayOfMonth(1))
        formGroupLocalDate.formComponent.setMax(LocalDate.now().withMonth(12).withDayOfMonth(31))
        formGroupView.add(formGroupLocalDate)

        val formGroupLocalTime = FormGroupLocalTime(
            formGroupView.newChildId(),
            Model(),
            Model(FormGroupLocalTime::class.java.simpleName)
        )
        formGroupView.add(formGroupLocalTime)

        val formGroupLocalDateTime = FormGroupLocalDateTime(
            formGroupView.newChildId(),
            Model(),
            Model(FormGroupLocalDateTime::class.java.simpleName)
        )
        formGroupView.add(formGroupLocalDateTime)

        val formGroupCheckBox = FormGroupCheckBox(
            formGroupView.newChildId(),
            Model(),
            Model(FormGroupCheckBox::class.java.simpleName)
        )
        formGroupView.add(formGroupCheckBox)

        val formGroupRadioChoice = FormGroupRadioChoice(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupRadioChoice::class.java.simpleName),
            ListModel(choices)
        )
        formGroupView.add(formGroupRadioChoice)

        val formGroupSelect = FormGroupSelect(
            formGroupView.newChildId(),
            Model.of(""),
            Model(FormGroupSelect::class.java.simpleName),
            ListModel(choices)
        )
        formGroupSelect.setRequired(false)
        formGroupSelect.setNullValid(true)
        formGroupView.add(formGroupSelect)

        val formGroupInputFile = FormGroupInputFile(
            formGroupView.newChildId(),
            ListModel(),
            Model(FormGroupInputFile::class.java.simpleName)
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