package examples

import processing.core.PApplet

class TrailingCircles : PApplet() {

    init {
        setSize(800, 600)
        runSketch()
    }


    override fun setup() {
        background(0)
    }

    private val maxTrailsSize = 100


    private val processList = mutableListOf<() -> Unit>()

    var noiseOffset = 0f

    var radius = 0f

    override fun draw() {

        processList.forEachIndexed { index, function ->
            if (index < maxTrailsSize) {
                fill(min(index * 3, 255))
            }

            radius = (index.toFloat() % 25) + 1

            function.invoke()

            noiseOffset += 0.0001f
        }


        val offset = noiseOffset

        processList.add {
            circle(
                noise(offset) * width, noise(offset, -offset) * height, radius
            )
        }

        if (processList.size > maxTrailsSize) {
            processList.removeFirstOrNull()
        }
    }
}
