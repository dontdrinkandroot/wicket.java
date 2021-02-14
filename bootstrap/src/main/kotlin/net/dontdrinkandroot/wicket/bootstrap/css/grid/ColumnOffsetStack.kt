package net.dontdrinkandroot.wicket.bootstrap.css.grid

class ColumnOffsetStack(
    private val columnOffsetDefault: ColumnOffset?,
    private val columnOffsetSmall: ColumnOffset?,
    private val columnOffsetMedium: ColumnOffset?,
    private val columnOffsetLarge: ColumnOffset?
) : ColumnOffset {

    override val classString: String
        get() {
            val classBuffer = StringBuffer()
            if (null != columnOffsetDefault) {
                classBuffer.append(columnOffsetDefault.classString)
                classBuffer.append(" ")
            }
            if (null != columnOffsetSmall) {
                classBuffer.append(columnOffsetSmall.classString)
                classBuffer.append(" ")
            }
            if (null != columnOffsetMedium) {
                classBuffer.append(columnOffsetMedium.classString)
                classBuffer.append(" ")
            }
            if (null != columnOffsetLarge) {
                classBuffer.append(columnOffsetLarge.classString)
                classBuffer.append(" ")
            }

            return classBuffer.toString().trim { it <= ' ' }
        }

    override val inverseColumnSize: ColumnSize
        get() {
            val columnSizeDefault = if (columnOffsetDefault == null) null else columnOffsetDefault.inverseColumnSize
            val columnSizeSmall = if (columnOffsetSmall == null) null else columnOffsetSmall.inverseColumnSize
            val columnSizeMedium = if (columnOffsetMedium == null) null else columnOffsetMedium.inverseColumnSize
            val columnSizeLarge = if (columnOffsetLarge == null) null else columnOffsetLarge.inverseColumnSize
            return ColumnSizeStack(columnSizeDefault, columnSizeSmall, columnSizeMedium, columnSizeLarge)
        }

    override val inverseColumnOffset: ColumnOffset
        get() {
            val columnOffsetDefault = if (columnOffsetDefault == null) null else columnOffsetDefault.inverseColumnOffset
            val columnOffsetSmall = if (columnOffsetSmall == null) null else columnOffsetSmall.inverseColumnOffset
            val columnOffsetMedium = if (columnOffsetMedium == null) null else columnOffsetMedium.inverseColumnOffset
            val columnOffsetLarge = if (columnOffsetLarge == null) null else columnOffsetLarge.inverseColumnOffset
            return ColumnOffsetStack(columnOffsetDefault, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge)
        }
}