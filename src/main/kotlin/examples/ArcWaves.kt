package examples

import processing.core.PApplet

class ArcWaves : PApplet() {

    private var increment = 0f
    private var perlinOffset = 0f

    init {
        setSize(852, 852)
        runSketch()
    }


    override fun setup() {

    }


    override fun draw() {
        scale(1.5f, 1.5f)
        translate(0f, -20f)

        increment += increment
        background(37f, 74f, 108f)
        noFill()

        perlinOffset += 0.05f

        (0..height).forEach { verticalPixel ->
            stroke(135f, 164f, 196f, 255f)

            if (verticalPixel % 15 == 0) {

                (-width..width).forEach { horizontalPixel ->
                    strokeWeight(
                        noise(
                            horizontalPixel.toFloat() + perlinOffset,
                            verticalPixel.toFloat() + perlinOffset
                        ) * verticalPixel / 50f
                    )

                    if (horizontalPixel % 50 == 0) {
                        val startAngle = if (horizontalPixel % 100 == 0) {
                            0f
                        } else {
                            PI
                        }
                        arc(
                            horizontalPixel.toFloat() + (perlinOffset * sin(perlinOffset + verticalPixel + horizontalPixel / 4f)),
                            verticalPixel.toFloat(),
                            50f,
                            50f,
                            startAngle,
                            startAngle + PI
                        )
                    }
                }

            }
        }
    }
}
