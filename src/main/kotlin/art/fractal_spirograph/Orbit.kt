package art.fractal_spirograph

import processing.core.PApplet
import processing.core.PApplet.cos
import processing.core.PApplet.sin

class Orbit(angle: Float, val xCord: Float, val yCord: Float, val radius: Float, iteration: Int) {

    fun drawCircle(applet: PApplet) {
        applet.circle(xCord, yCord, radius)
    }

}
