package css.com.applab.view

import android.graphics.Matrix
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation

class GenHandler : View.OnTouchListener {
    private var mapPreviewView: View
    private var rootView: View
    private var scaleGestureDetector: ScaleGestureDetector
    private var gestureDetector: GestureDetector
    private var matrix: Matrix
    private var baseScale = 1f


    constructor(mapPreviewView: View, rootView: View) {
        this.mapPreviewView = mapPreviewView
        this.rootView = rootView
        rootView.setOnTouchListener(this)
        scaleGestureDetector = ScaleGestureDetector(rootView.context, ScaleListener())
        gestureDetector = GestureDetector(rootView.context, SimpleListener())
        matrix = Matrix()
    }

    inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            println("onScaleBegin")
//            isInScaleMode = true
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {

            var mScaleFactor = detector.scaleFactor
            println("onScale mScaleFactor:$mScaleFactor")
            if (mScaleFactor > 1) {
                // morer big

            } else {
                // more small
            }
            matrix.postScale(mScaleFactor, mScaleFactor, detector.focusX, detector.focusY)
//            mapPreviewView.animationMatrix = matrix
//            var s = ScaleAnimation(mScaleFactor, mScaleFactor, detector.focusX, detector.focusY)
//            mapPreviewView.startAnimation(s) // api high
//            mapPreviewView.animation=MyAnimation(matrix) // invalid
            baseScale *= mScaleFactor
            mapPreviewView.scaleX = baseScale
            mapPreviewView.scaleY = baseScale
            return true
        }
    }

    inner class SimpleListener : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(
                e1: MotionEvent?,
                e2: MotionEvent?,
                distanceX: Float,
                distanceY: Float
        ): Boolean {
            println("distanceX:$distanceX distanceY:$distanceY")
            matrix.postTranslate(-distanceX, -distanceY)
//            var t =TranslateAnimation(0f, -distanceX, 0f, -distanceY)
//            mapPreviewView.startAnimation(t)
//            mapPreviewView.animationMatrix = matrix// api high
//            mapPreviewView.animation=MyAnimation(matrix)// invalid
//            mapPreviewView.translationX = -distanceX
//            mapPreviewView.translationY = -distanceY
            rootView.scrollBy(distanceX.toInt(), distanceY.toInt())
            return true
        }
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        gestureDetector.onTouchEvent(event)
        return true
    }

    internal class MyAnimation(private val matrix: Matrix) : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            super.applyTransformation(interpolatedTime, t)
            t.getMatrix().set(matrix)
        }
    }
}
