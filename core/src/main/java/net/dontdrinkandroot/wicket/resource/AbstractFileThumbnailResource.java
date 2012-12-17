package net.dontdrinkandroot.wicket.resource;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.resource.AbstractResource;
import org.apache.wicket.util.io.IOUtils;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.util.time.Time;


public abstract class AbstractFileThumbnailResource extends AbstractResource {

	private static final long serialVersionUID = 1L;


	@Override
	protected ResourceResponse newResourceResponse(final Attributes attributes) {

		final File file = this.resolveFile(attributes);

		final Integer width = this.resolveWidth(attributes);

		final byte[] imageBytes;
		try {

			if (width == null) {

				final FileInputStream fis = new FileInputStream(file);
				final ByteArrayOutputStream imageBytesStream = new ByteArrayOutputStream();
				IOUtils.copy(fis, imageBytesStream);
				imageBytes = imageBytesStream.toByteArray();
				IOUtils.closeQuietly(fis);

			} else {

				final BufferedImage bufferedImage = ImageIO.read(file);
				final int oldWidth = bufferedImage.getWidth();
				final int oldHeight = bufferedImage.getHeight();
				final int newWidth = width.intValue();
				final int newHeight = newWidth * oldHeight / oldWidth;
				final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
				final Graphics2D g2d = (Graphics2D) scaledImage.getGraphics();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawImage(bufferedImage, 0, 0, newWidth, newHeight, 0, 0, oldWidth, oldHeight, null);
				g2d.dispose();
				final ByteArrayOutputStream imageBytesStream = new ByteArrayOutputStream();
				ImageIO.write(scaledImage, "jpg", imageBytesStream);
				imageBytes = imageBytesStream.toByteArray();

			}

		} catch (final IOException e) {
			throw new WicketRuntimeException(e);
		}

		final ResourceResponse resourceResponse = new ResourceResponse() {

			@Override
			public WriteCallback getWriteCallback() {

				return new WriteCallback() {

					@Override
					public void writeData(final Attributes attributes) {

						try {
							this.writeStream(attributes, new ByteArrayInputStream(imageBytes));
						} catch (IOException e) {
							throw new WicketRuntimeException(e);
						}
					}
				};
			}
		};
		resourceResponse.setContentType("image/jpeg");
		resourceResponse.setLastModified(Time.millis(file.lastModified()));
		resourceResponse.setCacheDuration(this.getCacheDuration());
		resourceResponse.setContentLength(imageBytes.length);

		return resourceResponse;
	}


	protected Duration getCacheDuration() {

		return WebResponse.MAX_CACHE_DURATION;
	}


	protected abstract Integer resolveWidth(Attributes attributes);


	protected abstract File resolveFile(Attributes attributes);
}
