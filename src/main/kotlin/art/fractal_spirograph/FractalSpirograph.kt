package art.fractal_spirograph

import processing.core.PApplet
import processing.core.PVector

class FractalSpirograph : PApplet() {

    init {
        setSize(800, 800)
        runSketch()
    }


    override fun setup() {

    }

    private val list = mutableListOf<PVector>()


    override fun draw() {
        background(0)
        stroke(255f)
        noFill()
        strokeWeight(2f)

        val radius = 200f
        val x = width / 2f
        val y = height / 2f

        translate(x, y)

        circle(0f, 0f, radius * 2)

        val angle = radians(frameCount.toFloat())

        val newRadius = radius + (radius * 0.5f)

        val newX = cos(angle) * newRadius
        val newY = sin(angle) * newRadius

        circle(newX, newY,  radius)

//        Orbit((noise(frameCount * 0.001f)) * PI, 0f, 0f, radius, 0).run {
//            circle(0f, 0f, radius)
//        }


//        noLoop()
    }

}
