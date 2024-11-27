public class Andrey implements User{
    private static Andrey instance = new Andrey();

    private Andrey(){
    }

    public static Andrey getInstance(){
        return instance;
    }

    @Override
    public String getName(){
        return "Андрей";
    }
    @Override
    public String getFilePath() {
        return "C:\\Users\\icefo\\SaveObjects.txt";
    }
}
