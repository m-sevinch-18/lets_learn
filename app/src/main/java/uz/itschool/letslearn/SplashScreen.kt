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

    private lateinit var mainimagesplash: ImageView
    private lateinit var textsplash: ImageView

    private val SPLASH_TIME: Long = 4800

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize views after setContentView
        mainimagesplash = findViewById(R.id.mainimagesplash)
        textsplash = findViewById(R.id.textsplash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME)

        val top_anim: Animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottom_anim: Animation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        mainimagesplash.startAnimation(top_anim)
        textsplash.startAnimation(bottom_anim)
    }
}
