public class Post_VID implements User{
    private static Post_VID instance = new Post_VID();

    private Post_VID(){
    }

    public static Post_VID getInstance(){
        return instance;
    }

    @Override
    public String getName(){
        return "Post_VID";
    }
    @Override
    public String getFilePath() {
        return "C:\\Users\\icefo\\SaveObjects.txt";
    }
}
