package examples

import processing.core.PApplet

class DisplacedLines : PApplet() {

    init {
        setSize(800, 600)
        runSketch()
    }

    override fun draw() {
        background(20)

        noFill()


        (0..height).forEach { verticalPixel ->
            if (verticalPixel % 80 == 0) {
                drawLine(verticalPixel)
            }
        }
        perlinOffset += 0.01f
    }

    override fun setup() {

    }

    var perlinOffset = 0f

    private fun drawLine(verticalPixel: Int) {
        beginShape()
        (0..width).forEach { horizontalPixel ->
            if (horizontalPixel % 50 == 0) {
                stroke(
                    map(abs(verticalPixel.toFloat()), 0f, height.toFloat(), 10f, 255f)
                )

                vertex(
                    horizontalPixel.toFloat(),
                    verticalPixel.toFloat()
                            + sin(horizontalPixel.toFloat() + verticalPixel)
                            * noise(perlinOffset)
                            * random((verticalPixel.toFloat() % horizontalPixel/20))

                )
            }
        }
        endShape()
    }


}
