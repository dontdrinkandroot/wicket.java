package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.markup.html.form.upload.FileUpload
import org.apache.wicket.markup.html.form.upload.FileUploadField
import org.apache.wicket.model.IModel

class FormGroupInputFile(id: String, model: IModel<List<FileUpload>>, labelModel: IModel<String>) :
    FormGroupFormComponent<List<FileUpload>, List<FileUpload>, FileUploadField>(id, model, labelModel) {

    private var multiple = false

    override fun createFormComponent(id: String): FileUploadField {
        val fileUploadField = FileUploadField(id, this.model)
        fileUploadField.add(AttributeAppender("multiple", IModel<Any?> {
            if (multiple) "multiple" else null
        }))
        return fileUploadField
    }

    fun setMultiple(multiple: Boolean) {
        this.multiple = multiple
    }
}