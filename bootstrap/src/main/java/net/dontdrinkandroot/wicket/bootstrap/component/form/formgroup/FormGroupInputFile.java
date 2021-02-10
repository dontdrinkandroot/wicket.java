package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.IModel;

import java.util.List;

public class FormGroupInputFile extends FormGroupFormComponent<List<FileUpload>, List<FileUpload>, FileUploadField>
{
    private boolean multiple = false;

    public FormGroupInputFile(String id, IModel<String> labelModel, IModel<List<FileUpload>> model) {
        super(id, model, labelModel);
    }

    @Override
    protected FileUploadField createFormComponent(String id)
    {
        FileUploadField fileUploadField = new FileUploadField(id, this.getModel());
        fileUploadField.add(new AttributeAppender("multiple", () -> {
            if (FormGroupInputFile.this.multiple) {
                return "multiple";
            }
            return null;
        }));

        return fileUploadField;
    }

    public void setMultiple(boolean multiple)
    {
        this.multiple = multiple;
    }
}
