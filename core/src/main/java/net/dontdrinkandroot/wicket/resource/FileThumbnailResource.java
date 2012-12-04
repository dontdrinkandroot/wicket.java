package net.dontdrinkandroot.wicket.resource;

import java.io.File;


public class FileThumbnailResource extends AbstractFileThumbnailResource {

	private static final long serialVersionUID = 1L;

	private final File file;

	private Integer width = null;


	public FileThumbnailResource(final File file) {

		super();

		this.file = file;
	}


	public FileThumbnailResource(final File file, final int width) {

		this.file = file;
		this.width = width;
	}


	@Override
	protected File resolveFile(final Attributes attributes) {

		return this.file;
	}


	@Override
	protected Integer resolveWidth(final Attributes attributes) {

		return this.width;
	}

}
