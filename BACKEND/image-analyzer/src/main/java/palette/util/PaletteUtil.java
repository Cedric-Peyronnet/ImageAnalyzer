package palette.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import palette.Palette;

public final class PaletteUtil {

    private static final int LENGTH_PALETTE = 3;

    public static Palette getPalette(MultipartFile image) {
        //TODO - get main colors from image in params
        return new Palette("color 1", "color 2", "color 3");
    }

    public static Palette arrayTopalette(int[][] paletteArray) {
        Palette palette = new Palette();

        if(paletteArray.length == LENGTH_PALETTE) {
            palette.setMainColor(rgbToHEX(paletteArray[0][0], paletteArray[0][1], paletteArray[0][2]));
            palette.setSecondColor(rgbToHEX(paletteArray[1][0], paletteArray[1][1], paletteArray[1][2]));
            palette.setThirdColor(rgbToHEX(paletteArray[2][0], paletteArray[2][1], paletteArray[2][2]));
        }

        return palette;
    }

    public static String rgbToHEX(int r, int g, int b) {
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public static JSONObject paletteToJson(Palette palette) {
        JSONObject paletteJson = new JSONObject();

        if (palette.isPaletteFull()) {
            try {
                paletteJson.put("mainColor", palette.getMainColor());
                paletteJson.put("secondColor", palette.getSecondColor());
                paletteJson.put("thirdColor", palette.getThirdColor());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return paletteJson;
    }

    public static String extractMainRGB(int[][] paletteArray) {
        int r = paletteArray[0][0];
        int g = paletteArray[0][1];
        int b = paletteArray[0][2];

        String codeColor = "";
        int maxValue = 0;

        if (r > maxValue) {
            maxValue = r;
            codeColor = "R";
        }
        if (g > maxValue) {
            maxValue = g;
            codeColor = "G";
        }
        if (b > maxValue) {
            maxValue = b;
            codeColor = "B";
        }

        return codeColor;

    }
}
