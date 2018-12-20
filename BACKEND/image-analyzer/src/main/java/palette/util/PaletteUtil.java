package palette.util;

import org.springframework.web.multipart.MultipartFile;
import palette.Palette;

public final class PaletteUtil {



    public static Palette getPalette(MultipartFile image) {
        //TODO - get main colors from image in params
        return new Palette("color 1", "color 2", "color 3");
    }
}
