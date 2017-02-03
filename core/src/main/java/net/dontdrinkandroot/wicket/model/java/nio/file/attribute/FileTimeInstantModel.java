package net.dontdrinkandroot.wicket.model.java.nio.file.attribute;

import net.dontdrinkandroot.wicket.model.AbstractChainedReadonlyModel;
import org.apache.wicket.model.IModel;

import java.nio.file.attribute.FileTime;
import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FileTimeInstantModel extends AbstractChainedReadonlyModel<FileTime, Instant>
{
    public FileTimeInstantModel(IModel<? extends FileTime> parent)
    {
        super(parent);
    }

    @Override
    public Instant getObject()
    {
        return this.getParentObject().toInstant();
    }
}
