import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRenderer {
    public static void renderTextOnImage(String imagePath, String text, String outputPath) throws IOException {
        File input = new File(imagePath);
        BufferedImage image = ImageIO.read(input);

        Graphics2D g = image.createGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(text, 50, 50); // Position text on the image
        g.dispose();

        File output = new File(outputPath);
        ImageIO.write(image, "png", output);
    }
}


    

