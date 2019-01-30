package `in`.januprasad.calender

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class TextView3 : AppCompatTextView {

    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, "Sarabun-Bold.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, "Sarabun-Bold.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        val face = Typeface.createFromAsset(context.assets, "Sarabun-Bold.ttf")
        this.typeface = face
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}
