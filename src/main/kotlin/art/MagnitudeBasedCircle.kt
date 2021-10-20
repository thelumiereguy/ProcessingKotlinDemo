package art

import processing.core.PApplet

class MagnitudeBasedCircle : PApplet() {

    init {
        setSize(2048, 2048)
        runSketch()
    }


    override fun setup() {
        colorMode(HSB, 360f, 100f, 100f, 100f)

        background(0)

        val halfWidth = width / 2f
        val halfHeight = height / 2f
        noFill()

        strokeWeight(3f)

        translate(halfWidth, halfHeight)

        repeat(100) { index ->
            stroke(3.5f * index,50f,50f)

            val angle = radians((360f / 100) * index)

            val circumX = cos(angle) * 512f
            val circumY = sin(angle) * 512f

            pushMatrix()

            rotate(frameCount * 0.001f)

            line(0f, 0f, circumX, circumY)

            val endPoint = getMinimum(circumX, circumY, halfWidth, halfHeight)

            popMatrix()

            line(circumX, circumY, endPoint.first, endPoint.second)
        }

        save("/snaps/magnitudeBasedCircle.png")
    }

    private val maxTrailsSize = 5


    private val processList = mutableListOf<() -> Unit>()


    override fun draw() {

    }

    private fun getMinimum(valueX: Float, valueY: Float, boundX: Float, boundY: Float): Pair<Float, Float> {
        return when {
            valueX > 0 && valueY > 0 -> boundX to valueY
            valueX > 0 && valueY < 0 -> valueX to -boundY
            valueX < 0 && valueY < 0 -> -boundX to valueY
            valueX < 0 && valueY > 0 -> valueX to boundY
            else -> valueX to valueY
        }
    }
}
