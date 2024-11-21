public class PictureTranslationApp {
    public static void main(String[] args) {
        String inputImagePath = "path/to/input/image.jpg";
        String outputImagePath = "path/to/output/image_translated.png";
        String targetLanguage = "es"; // Example: Spanish

        try {
            // Step 1: Extract text from image
            String extractedText = OCRProcessor.extractTextFromImage(inputImagePath);
            System.out.println("Extracted Text: " + extractedText);

            // Step 2: Translate text
            String translatedText = Translator.translateText(extractedText, targetLanguage);
            System.out.println("Translated Text: " + translatedText);

            // Step 3: Render text on image
            ImageRenderer.renderTextOnImage(inputImagePath, translatedText, outputImagePath);
            System.out.println("Translated image saved at: " + outputImagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
