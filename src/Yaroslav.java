public class Yaroslav implements User{
    private static Yaroslav instance = new Yaroslav();

    private Yaroslav(){
    }

    public static Yaroslav getInstance(){
        return instance;
    }

    @Override
    public String getName(){
        return "Ярослав";
    }
    @Override
    public String getFilePath() {
        return "C:\\Users\\icefo\\SaveObjects.txt";
    }
}
