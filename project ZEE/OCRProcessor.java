import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class OCRProcessor {
    public static String extractTextFromImage(String imagePath) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata"); // Path to tessdata directory
        tesseract.setLanguage("eng"); // Set language to English

        try {
            return tesseract.doOCR(new File(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }
}
