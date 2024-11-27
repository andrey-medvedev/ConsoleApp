public class Rostislav implements User{
    private static Rostislav instance = new Rostislav();

    private Rostislav(){
    }

    public static Rostislav getInstance(){
        return instance;
    }

    @Override
    public String getName(){
        return "Ростислав";
    }
    @Override
    public String getFilePath() {
        return "C:\\Users\\icefo\\SaveObjects.txt";
    }
}
