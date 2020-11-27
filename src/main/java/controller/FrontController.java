package controller;

public interface FrontController {

    //index is for getting all the things of the object
    public abstract String index();

    public abstract String getObjectById(int id);

}
