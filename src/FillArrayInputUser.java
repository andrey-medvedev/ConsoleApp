public class FillArrayInputUser implements FillingArray{

    @Override
    public void fillArray(CustomClassBuilder builder) {
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromConsole(Controller.getNumberOfObjects())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }
}
