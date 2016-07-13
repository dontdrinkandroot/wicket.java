package net.dontdrinkandroot.wicket.bootstrap.css;

public class ColumnSizeStack implements ColumnSize
{

	private ColumnSizeExtraSmall columnSizeExtraSmall;

	private ColumnSizeSmall columnSizeSmall;

	private ColumnSizeMedium columnSizeMedium;

	private ColumnSizeLarge columnSizeLarge;


	public ColumnSizeStack(
			ColumnSizeExtraSmall columnSizeExtraSmall,
			ColumnSizeSmall columnSizeSmall,
			ColumnSizeMedium columnSizeMedium,
			ColumnSizeLarge columnSizeLarge)
	{
		super();
		this.columnSizeExtraSmall = columnSizeExtraSmall;
		this.columnSizeSmall = columnSizeSmall;
		this.columnSizeMedium = columnSizeMedium;
		this.columnSizeLarge = columnSizeLarge;
	}

	@Override
	public String getClassString()
	{
		StringBuffer classBuffer = new StringBuffer();
		if (null != this.columnSizeExtraSmall) {
			classBuffer.append(this.columnSizeExtraSmall.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnSizeSmall) {
			classBuffer.append(this.columnSizeSmall.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnSizeMedium) {
			classBuffer.append(this.columnSizeMedium.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnSizeLarge) {
			classBuffer.append(this.columnSizeLarge.getClassString());
			classBuffer.append(" ");
		}

		return classBuffer.toString().trim();
	}

	@Override
	public ColumnOffset getInverseColumnOffset()
	{
		ColumnOffsetExtraSmall columnOffsetExtraSmall =
				this.columnSizeExtraSmall == null ? null : this.columnSizeExtraSmall.getInverseColumnOffset();
		ColumnOffsetSmall columnOffsetSmall =
				this.columnSizeSmall == null ? null : this.columnSizeSmall.getInverseColumnOffset();
		ColumnOffsetMedium columnOffsetMedium =
				this.columnSizeMedium == null ? null : this.columnSizeMedium.getInverseColumnOffset();
		ColumnOffsetLarge columnOffsetLarge =
				this.columnSizeLarge == null ? null : this.columnSizeLarge.getInverseColumnOffset();

		return new ColumnOffsetStack(columnOffsetExtraSmall, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge);
	}

	@Override
	public ColumnSize getInverseColumnSize()
	{
		ColumnSizeExtraSmall columnSizeExtraSmall =
				this.columnSizeExtraSmall == null ? null : this.columnSizeExtraSmall.getInverseColumnSize();
		ColumnSizeSmall columnSizeSmall =
				this.columnSizeSmall == null ? null : this.columnSizeSmall.getInverseColumnSize();
		ColumnSizeMedium columnSizeMedium =
				this.columnSizeMedium == null ? null : this.columnSizeMedium.getInverseColumnSize();
		ColumnSizeLarge columnSizeLarge =
				this.columnSizeLarge == null ? null : this.columnSizeLarge.getInverseColumnSize();

		return new ColumnSizeStack(columnSizeExtraSmall, columnSizeSmall, columnSizeMedium, columnSizeLarge);
	}

}
