package art.phyllotaxis

import processing.core.PApplet
import processing.event.KeyEvent

class BirdsEyeVariation : PApplet() {

    init {
        setSize(1024, 1024)
        runSketch()
    }


    override fun setup() {
        colorMode(HSB, 360f, 100f, 100f, 100f)
        frameRate(120f)
        noStroke()
    }

    override fun keyPressed(event: KeyEvent?) {
        super.keyPressed(event)
        if (event?.key == 's') {
            save("/birdsEye/BirdsEye.png")
        }
    }


    private val constant = 4

    private val processList = mutableListOf<(Int) -> Unit>()

    private val maxTrailsSize = 1500

    override fun draw() {
        background(0)

        translate(width / 2f, height / 2f)

        processList.forEachIndexed { index, function ->
            function.invoke(index)
        }

        val current = frameCount

        processList.add { index ->

            val angle = current * 137.5f
            val radius = constant * sqrt(current.toFloat())

            val x = radius * cos(angle)
            val y = radius * sin(angle)

            if (index < maxTrailsSize) {
                fill(map(radius, 0f, 100f, 255f, 0f), radius - 5, index.toFloat() % 360f)
            }

            pushMatrix()
            circle(x, y, y * 0.5f)
            val offset = sin(frameCount.toFloat()) + (1 - radius)
            translate((width / 2f) + offset, (height / 2f) + offset)
            popMatrix()
        }

        if (processList.size > maxTrailsSize) {
            processList.removeFirstOrNull()
        }
    }

}
