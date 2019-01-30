package palette;

public class Palette {

    private String mainColor;
    private String secondColor;
    private String thirdColor;

    public Palette() {

    }

    public Palette(String mainColor, String secondColor, String thirdColor) {
        this.mainColor = mainColor;
        this.secondColor = secondColor;
        this.thirdColor = thirdColor;
    }

    public String getMainColor() {
        return mainColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public String getThirdColor() {
        return thirdColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public void setThirdColor(String thirdColor) {
        this.thirdColor = thirdColor;
    }

    public boolean isPaletteFull() {
        return !this.mainColor.trim().isEmpty()
                && !this.secondColor.trim().isEmpty()
                && !this.thirdColor.trim().isEmpty();
    }
}
