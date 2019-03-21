import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Skizze
{
    // Attribute
    GraphicsContext gc;

    //Konstruktor
    Skizze(GraphicsContext gc_)
    {
        gc = gc_;
        zeichnen();
    }

    //Methoden
    void zeichnen()
    {
        gc.setStroke(Color.BLACK);
        for (double x = 0; x < 800; x = x + 10)
        {
            for (double y = 0; y < 600; y = y + 10)
            {
                double r = 1;
                double g = (Math.sin(x/100) +1) * 0.5;
                double b = (Math.sin(y/100) +1) * 0.5;
                Color color = Color.color(r,g,b);
                gc.setFill(color);
                gc.fillRect(x,y,10,10);
            }
        }
    }

}
