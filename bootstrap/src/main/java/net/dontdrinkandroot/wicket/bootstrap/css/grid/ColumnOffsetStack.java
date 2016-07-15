package net.dontdrinkandroot.wicket.bootstrap.css.grid;

public class ColumnOffsetStack implements ColumnOffset
{

	private ColumnOffsetExtraSmall columnOffsetExtraSmall;

	private ColumnOffsetSmall columnOffsetSmall;

	private ColumnOffsetMedium columnOffsetMedium;

	private ColumnOffsetLarge columnOffsetLarge;


	public ColumnOffsetStack(
			ColumnOffsetExtraSmall columnOffsetExtraSmall,
			ColumnOffsetSmall columnOffsetSmall,
			ColumnOffsetMedium columnOffsetMedium,
			ColumnOffsetLarge columnOffsetLarge)
	{
		super();
		this.columnOffsetExtraSmall = columnOffsetExtraSmall;
		this.columnOffsetSmall = columnOffsetSmall;
		this.columnOffsetMedium = columnOffsetMedium;
		this.columnOffsetLarge = columnOffsetLarge;
	}

	@Override
	public String getClassString()
	{
		StringBuffer classBuffer = new StringBuffer();
		if (null != this.columnOffsetExtraSmall) {
			classBuffer.append(this.columnOffsetExtraSmall.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnOffsetSmall) {
			classBuffer.append(this.columnOffsetSmall.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnOffsetMedium) {
			classBuffer.append(this.columnOffsetMedium.getClassString());
			classBuffer.append(" ");
		}
		if (null != this.columnOffsetLarge) {
			classBuffer.append(this.columnOffsetLarge.getClassString());
			classBuffer.append(" ");
		}

		return classBuffer.toString().trim();
	}

	@Override
	public ColumnSize getInverseColumnSize()
	{
		ColumnSizeExtraSmall columnSizeExtraSmall =
				this.columnOffsetExtraSmall == null ? null : this.columnOffsetExtraSmall.getInverseColumnSize();
		ColumnSizeSmall columnSizeSmall =
				this.columnOffsetSmall == null ? null : this.columnOffsetSmall.getInverseColumnSize();
		ColumnSizeMedium columnSizeMedium =
				this.columnOffsetMedium == null ? null : this.columnOffsetMedium.getInverseColumnSize();
		ColumnSizeLarge columnSizeLarge =
				this.columnOffsetLarge == null ? null : this.columnOffsetLarge.getInverseColumnSize();

		return new ColumnSizeStack(columnSizeExtraSmall, columnSizeSmall, columnSizeMedium, columnSizeLarge);
	}

	@Override
	public ColumnOffset getInverseColumnOffset()
	{
		ColumnOffsetExtraSmall columnOffsetExtraSmall =
				this.columnOffsetExtraSmall == null ? null : this.columnOffsetExtraSmall.getInverseColumnOffset();
		ColumnOffsetSmall columnOffsetSmall =
				this.columnOffsetSmall == null ? null : this.columnOffsetSmall.getInverseColumnOffset();
		ColumnOffsetMedium columnOffsetMedium =
				this.columnOffsetMedium == null ? null : this.columnOffsetMedium.getInverseColumnOffset();
		ColumnOffsetLarge columnOffsetLarge =
				this.columnOffsetLarge == null ? null : this.columnOffsetLarge.getInverseColumnOffset();

		return new ColumnOffsetStack(columnOffsetExtraSmall, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge);
	}

}
