public class FillArrayRandom implements FillingArray{


    @Override
    public void fillArray(CustomClassBuilder builder) {
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromRandom(Controller.getNumberOfObjects())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }

}
