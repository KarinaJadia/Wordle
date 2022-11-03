public class Word {
    String wor;
    int length;

    public Word () {
        wor = "";
        length = 0;
    }
    public void setWord (String wor) {
        this.wor = wor;
        length = this.wor.length();
    }
    public String getWord () {
        return wor;
    }
    public int getLength () {
        return length;
    }
}