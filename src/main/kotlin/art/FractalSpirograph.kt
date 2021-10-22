package art

import processing.core.PApplet

class FractalSpirograph : PApplet() {

    init {
        setSize(800, 800)
        runSketch()
    }


    override fun setup() {

    }


    override fun draw() {
        background(0)
        stroke(255f)
        noFill()
        strokeWeight(2f)

        translate(width / 2f, height / 2f)

        val radius = 100f
        val x = 0f
        val y = 0f

        drawCircle(x, y, radius, 30)

        noLoop()
    }

    private tailrec fun drawCircle(x: Float, y: Float, radius: Float, iterations: Int) {
        circle(x, y, radius * 2f)
        if (iterations > 1) {
            val halfRadius = (radius / 1.1f)
            val angle = radians(noise(iterations.toFloat()) * 360)
            drawCircle(
                (cos(angle) * radius),
                (sin(angle) * radius),
                halfRadius,
                iterations - 1
            )
        }
    }
}
