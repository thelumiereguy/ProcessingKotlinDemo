package examples

import processing.core.PApplet

class DivineIntervention : PApplet() {

    init {
        setSize(800, 800)
        runSketch()
    }

    override fun setup() {
        colorMode(HSB, 360f, 100f, 100f)
        background(0)
        strokeCap(ROUND)
        repeat(200) { it ->
            stroke(255)
            line(width / 2f, -100f, random(width.toFloat()), random(height.toFloat()))
        }
    }


    private var scale = 1f
    private var rotation = 1f

    override fun draw() {


        translate(width / 2f, height / 2f)
        scale(scale)
        stroke(0)
        strokeWeight(2f)
        (1..30).forEach { rings ->
            rotation += 0.00005f
            fill(23f, rings * 2.5F, 100f)
            (1..rings).forEach {
                val radius = 10f * rings
                val angle = radians(((360f / rings) * it)) + (rotation + (500 / rings) * scale)
                val x = radius * cos(angle)
                val y = radius * sin(angle)
                circle(x, y, max(rings * 0.3f, 2f))
            }
        }

        scale += 0.0005f

//        saveFrame("/circleArray/#####.png")
    }
}
