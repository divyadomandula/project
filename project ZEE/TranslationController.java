@RestController
@RequestMapping("/translate")
public class TranslationController {
    @PostMapping("/image")
    public ResponseEntity<?> translateImage(@RequestParam("file") MultipartFile file, @RequestParam("lang") String targetLanguage) {
        try {
            String imagePath = "uploads/" + file.getOriginalFilename();
            file.transferTo(new File(imagePath));

            String extractedText = OCRProcessor.extractTextFromImage(imagePath);
            String translatedText = Translator.translateText(extractedText, targetLanguage);
            String outputPath = "outputs/translated_" + file.getOriginalFilename();
            ImageRenderer.renderTextOnImage(imagePath, translatedText, outputPath);

            return ResponseEntity.ok("Image translated successfully. Output saved at: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the image");
        }
    }
}
