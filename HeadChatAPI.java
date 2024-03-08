public class HeadChatAPI {
    public static List<String> getFace(String name) {
        BufferedImage image = null;
        try {
            URL url = new URL(String.format("https://cravatar.eu/helmavatar/%s/8", name));
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processImage(image);
    }
    public static List<String> getFace(File img) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(img);
        } catch (IOException e) {
            System.err.println("Error reading image: " + img.getAbsolutePath());
            e.printStackTrace();
        }
        return processImage(image);
    }
    private static List<String> processImage(BufferedImage image) {
        List<String> lines = new ArrayList<>();

        if (image == null) return lines;

        for (int y = 0; y < image.getHeight(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                String hexColor = String.format("#%02X%02X%02X", red, green, blue);

                line.append("<").append(hexColor).append(">").append("\u2588");
            }
            lines.add(line.toString());
        }

        return lines;
    }
}
