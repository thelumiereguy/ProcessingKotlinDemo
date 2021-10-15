package examples

import processing.core.PApplet

class PerlinEllipseWave : PApplet() {

    init {
        setSize(800, 600)
        runSketch()
    }


    override fun setup() {
        background(20)
        smooth(4)
    }

    private var startOffset = 0f

    override fun draw() {

        background(20)

        stroke(255)

        noFill()

        var xOffset = startOffset

        beginShape()

        (0..width).forEach {
            if (it % 24 == 0) {
                val radius = map(noise(it.toFloat()), 0f, 1f, 0f, 24f)
                val offsetY = noise(xOffset) * height
                ellipse(it.toFloat(), offsetY, radius, radius)
                vertex(it.toFloat(), offsetY)
            }
            xOffset += 0.01f
        }

        endShape()

//        noLoop()

        startOffset += 0.001f
    }
}
