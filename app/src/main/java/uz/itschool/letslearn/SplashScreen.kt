package uz.itschool.letslearn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class SplashScreen : AppCompatActivity() {

    private var mainimagesplash = findViewById<ImageView>(R.id.mainimagesplash)
    private var textsplash = findViewById<ImageView>(R.id.textsplash)

    private val SPLASH_TIME : Long = 4800
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },SPLASH_TIME)

        var top_anim : Animation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        var bottom_anim: Animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        mainimagesplash.startAnimation(top_anim)
        textsplash.startAnimation(bottom_anim)


    }

}