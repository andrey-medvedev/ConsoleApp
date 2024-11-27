public class FillArrayReadFile implements FillingArray{

    @Override
    public void fillArray(CustomClassBuilder builder) {
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromFile(Controller.getFilePath())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }
}
