package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.ILinkListener;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class ButtonLink<T> extends AbstractButtonLink<T> implements ILinkListener {

	/**
	 * An anchor (form 'http://server/app/etc#someAnchor') will be appended to the link so that
	 * after this link executes, it will jump to the provided anchor component's position. The
	 * provided anchor must either have the {@link Component#getOutputMarkupId()} flag true, or it
	 * must be attached to a &lt;a tag with a href attribute of more than one character starting
	 * with '#' ('&lt;a href="#someAnchor" ... ').
	 */
	private Component anchor;

	/**
	 * True if link should automatically enable/disable based on current page; false by default.
	 */
	private boolean autoEnable = false;

	/**
	 * The popup specification. If not-null, a javascript on-click event handler will be generated
	 * that opens a new window using the popup properties.
	 */
	private PopupSettings popupSettings = null;


	public ButtonLink(String id) {

		super(id);
	}


	public ButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public ButtonLink(String id, String label) {

		super(id, null, new Model<String>(label));
	}


	public ButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	/**
	 * Gets any anchor component.
	 * 
	 * @return Any anchor component to jump to, might be null
	 */
	public Component getAnchor() {

		return this.anchor;
	}


	/**
	 * Gets whether link should automatically enable/disable based on current page.
	 * 
	 * @return Whether this link should automatically enable/disable based on current page.
	 */
	public final boolean getAutoEnable() {

		return this.autoEnable;
	}


	/**
	 * Gets the popup specification. If not-null, a javascript on-click event handler will be
	 * generated that opens a new window using the popup properties.
	 * 
	 * @return the popup specification.
	 */
	public final PopupSettings getPopupSettings() {

		return this.popupSettings;
	}


	/**
	 * @see org.apache.wicket.Component#isEnabled()
	 */
	@Override
	public boolean isEnabled() {

		/* If we're auto-enabling */
		if (this.getAutoEnable()) {
			/* the link is enabled if this link doesn't link to the current page */
			return !this.linksTo(this.getPage());
		}
		return super.isEnabled();
	}


	/**
	 * @see org.apache.wicket.Component#getStatelessHint()
	 */
	@Override
	protected boolean getStatelessHint() {

		return false;
	}


	/**
	 * Called when a link is clicked.
	 */
	public abstract void onClick();


	/**
	 * THIS METHOD IS NOT PART OF THE WICKET API. DO NOT ATTEMPT TO OVERRIDE OR CALL IT.
	 * 
	 * Called when a link is clicked. The implementation of this method is currently to simply call
	 * onClick(), but this may be augmented in the future.
	 * 
	 * @see ILinkListener
	 */
	@Override
	public final void onLinkClicked() {

		/* Invoke subclass handler */
		this.onClick();
	}


	/**
	 * Sets an anchor component. An anchor (form 'http://server/app/etc#someAnchor') will be
	 * appended to the link so that after this link executes, it will jump to the provided anchor
	 * component's position. The provided anchor must either have the
	 * {@link Component#getOutputMarkupId()} flag true, or it must be attached to a &lt;a tag with a
	 * href attribute of more than one character starting with '#' ('&lt;a href="#someAnchor" ...
	 * ').
	 * 
	 * @param anchor
	 *            The anchor
	 * @return this
	 */
	public ButtonLink<T> setAnchor(Component anchor) {

		this.addStateChange();
		this.anchor = anchor;
		return this;
	}


	/**
	 * Sets whether this link should automatically enable/disable based on current page.
	 * 
	 * @param autoEnable
	 *            whether this link should automatically enable/disable based on current page.
	 * @return This
	 */
	public final ButtonLink<T> setAutoEnable(final boolean autoEnable) {

		this.autoEnable = autoEnable;
		return this;
	}


	/**
	 * Sets the popup specification. If not-null, a javascript on-click event handler will be
	 * generated that opens a new window using the popup properties.
	 * 
	 * @param popupSettings
	 *            the popup specification.
	 * @return This
	 */
	public final ButtonLink<T> setPopupSettings(final PopupSettings popupSettings) {

		this.popupSettings = popupSettings;
		return this;
	}


	/**
	 * Appends any anchor to the url if the url is not null and the url does not already contain an
	 * anchor (url.indexOf('#') != -1). This implementation looks whether an anchor component was
	 * set, and if so, it will append the markup id of that component. That markup id is gotten by
	 * either calling {@link Component#getMarkupId()} if {@link Component#getOutputMarkupId()}
	 * returns true, or if the anchor component does not output it's id, this method will try to
	 * retrieve the id from the markup directly. If neither is found, an
	 * {@link WicketRuntimeException exception} is thrown. If no anchor component was set, but the
	 * link component is attached to a &lt;a element, this method will append what is in the href
	 * attribute <i>if</i> there is one, starts with a '#' and has more than one character.
	 * <p>
	 * You can override this method, but it means that you have to take care of whatever is done
	 * with any set anchor component yourself. You also have to manually append the '#' at the right
	 * place.
	 * </p>
	 * 
	 * @param tag
	 *            The component tag
	 * @param url
	 *            The url to start with
	 * @return The url, possibly with an anchor appended
	 */
	protected CharSequence appendAnchor(final ComponentTag tag, CharSequence url) {

		if (url != null) {
			Component anchor = this.getAnchor();
			if (anchor != null) {
				if (url.toString().indexOf('#') == -1) {
					String id;
					if (anchor.getOutputMarkupId()) {
						id = anchor.getMarkupId();
					} else {
						id = anchor.getMarkupAttributes().getString("id");
					}

					if (id != null) {
						url = url + "#" + anchor.getMarkupId();
					} else {
						throw new WicketRuntimeException("an achor component was set on "
								+ this
								+ " but it neither has outputMarkupId set to true "
								+ "nor has a id set explicitly");
					}
				}
			} else {
				if (tag.getName().equalsIgnoreCase("a")) {
					if (url.toString().indexOf('#') == -1) {
						String href = tag.getAttributes().getString("href");
						if (href != null && href.length() > 1 && href.charAt(0) == '#') {
							url = url + href;
						}
					}
				}
			}
		}
		return url;
	}


	/**
	 * @param url
	 *            The url for the link
	 * @return Any onClick JavaScript that should be used
	 */
	protected CharSequence getOnClickScript(final CharSequence url) {

		return null;
	}


	/**
	 * Gets the url to use for this link.
	 * 
	 * @return The URL that this link links to
	 */
	protected CharSequence getURL() {

		return this.urlFor(ILinkListener.INTERFACE, new PageParameters());
	}


	/**
	 * Whether this link refers to the given page.
	 * 
	 * @param page
	 *            A page
	 * @return True if this link goes to the given page
	 */
	protected boolean linksTo(final Page page) {

		return false;
	}


	/**
	 * Handles this link's tag. OVERRIDES MUST CALL SUPER.
	 * 
	 * @param tag
	 *            the component tag
	 * @see org.apache.wicket.Component#onComponentTag(ComponentTag)
	 */
	@Override
	protected void onComponentTag(final ComponentTag tag) {

		/* Default handling for tag */
		super.onComponentTag(tag);

		/* If we're disabled */
		if (!this.isLinkEnabled()) {
			this.disableLink(tag);
		} else {
			/* Set href to link to this link's linkClicked method */
			CharSequence url = this.getURL();

			/* append any anchor */
			url = this.appendAnchor(tag, url);

			/* if the tag is an anchor proper */
			if (tag.getName().equalsIgnoreCase("a")
					|| tag.getName().equalsIgnoreCase("link")
					|| tag.getName().equalsIgnoreCase("area")) {
				/* generate the href attribute */
				tag.put("href", url);

				/* Add any popup script */
				if (this.popupSettings != null) {
					/* NOTE: don't encode to HTML as that is not valid JavaScript */
					tag.put("onclick", this.popupSettings.getPopupJavaScript());
				}
			} else if (tag.getName().equalsIgnoreCase("script") || tag.getName().equalsIgnoreCase("style")) {
				tag.put("src", url);
			} else {
				/* generate a popup script by asking popup settings for one */
				if (this.popupSettings != null) {
					this.popupSettings.setTarget("'" + url + "'");
					String popupScript = this.popupSettings.getPopupJavaScript();
					tag.put("onclick", popupScript);
				} else {
					/*
					 * or generate an onclick JS handler directly in firefox when the element is
					 * quickly clicked 3 times a second request is generated during page load. This
					 * check ensures that the click is ignored
					 */
					tag.put("onclick", "var win = this.ownerDocument.defaultView || this.ownerDocument.parentWindow; "
							+ "if (win == window) { window.location.href='"
							+ url
							+ "'; } ;return false");
				}
			}

			/* If the subclass specified javascript, use that */
			final CharSequence onClickJavaScript = this.getOnClickScript(url);
			if (onClickJavaScript != null) {
				tag.put("onclick", onClickJavaScript);
			}
		}
	}

}
