package net.dontdrinkandroot.wicketexample.web.component;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Date;

import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.util.string.StringValue;


public class DateImageResource extends DynamicImageResource {

	@Override
	protected byte[] getImageData(Attributes attributes) {

		Date now;

		StringValue tStampValue = attributes.getParameters().get("tstamp");
		if (tStampValue == null) {
			tStampValue = attributes.getParameters().get(0);
		}

		if (!tStampValue.isNull()) {
			now = new Date(attributes.getParameters().get("tstamp").toLong());
		} else {
			now = new Date();
		}

		Font font = new Font("Helvetica", Font.PLAIN, 12);
		Rectangle2D bounds =
				font.getStringBounds(
						now.toString(),
						new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics().getFontRenderContext());

		BufferedImage img =
				new BufferedImage(
						(int) Math.ceil(bounds.getWidth()),
						(int) Math.ceil(bounds.getHeight()),
						BufferedImage.TYPE_INT_RGB);

		Graphics2D g = img.createGraphics();
		g.drawString(now.toString(), (float) -bounds.getX(), (float) -bounds.getY());

		g.dispose();

		return this.toImageData(img);
	}
}
