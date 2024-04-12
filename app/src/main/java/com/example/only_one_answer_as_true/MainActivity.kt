package com.example.only_one_answer_as_true

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.menu_tv)
        val btn1 = findViewById<Button>(R.id.start_btn)

        val displayMetrics = resources.displayMetrics
        val screenHeight = displayMetrics.heightPixels

        val animatorTV = createAlphaAnimation(tv, 0f, 0.9f)
        val animatorBTN = createAlphaAnimation(btn1, 0f, 0.9f)

        animatorTV.start()
        animatorBTN.start()

        btn1.setOnClickListener {
            setContentView(R.layout.main_menu)

            val text = findViewById<EditText>(R.id.request)
            val btn2 = findViewById<Button>(R.id.send_request)
            val CL = findViewById<ConstraintLayout>(R.id.CL1)
            val img = findViewById<ImageView>(R.id.image)

            CL.translationY = -screenHeight.toFloat() / 2

            val animatorTEXT = createAlphaAnimation(text, 0f, 0.9f)
            val animatorBTN2 = createAlphaAnimation(btn2, 0f, 0.9f)
            val animatorIMG = createAlphaAnimation(img, 0f, 1f)
            val animatorCLY = createTranslationYAnimation(CL, -screenHeight.toFloat() / 2, 0f)

            animatorIMG.startDelay = 5000

            animatorTEXT.start()
            animatorBTN2.start()

            btn2.setOnClickListener {
                animatorCLY.start()
                animatorIMG.start()
            }
        }
    }
    private fun createAlphaAnimation(view: View, a: Float, b: Float): ObjectAnimator {
        val animator = ObjectAnimator.ofFloat(view, "alpha", a, b)
        animator.duration = 5000
        return animator
    }
    private fun createTranslationYAnimation(view: View, a: Float, b: Float): ObjectAnimator {
        val animator = ObjectAnimator.ofFloat(view, "translationY", a, b)
        animator.duration = 5000
        return animator
    }
}