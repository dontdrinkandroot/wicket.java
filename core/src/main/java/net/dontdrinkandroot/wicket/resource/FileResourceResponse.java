package net.dontdrinkandroot.wicket.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.wicket.Application;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.request.resource.AbstractResource.ResourceResponse;
import org.apache.wicket.request.resource.AbstractResource.WriteCallback;
import org.apache.wicket.request.resource.IResource.Attributes;
import org.apache.wicket.util.time.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileResourceResponse extends ResourceResponse {

	private final File file;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	public FileResourceResponse(final File file) {

		this.file = file;
		final String contentType = Application.get().getMimeType(this.file.getAbsolutePath());
		this.setContentType(contentType);
		this.setLastModified(Time.millis(this.file.lastModified()));
		this.setContentLength(this.file.length());
	}


	@Override
	public WriteCallback getWriteCallback() {

		return new WriteCallback() {

			@Override
			public void writeData(final Attributes attributes) {

				try {
					this.writeStream(attributes, new FileInputStream(FileResourceResponse.this.file));
				} catch (final FileNotFoundException e) {
					throw new WicketRuntimeException(e);
				} catch (IOException e) {
					throw new WicketRuntimeException(e);
				}
			}
		};
	}

}
