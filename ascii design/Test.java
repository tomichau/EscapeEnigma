class Test extends Program{
    void algorithm(){
        String logo = fileAsString("./logoJeu.txt");
        String manoir = fileAsString("./manoir.txt");
        println(logo);
        println("1. Continuer  2.Créer un partie 3.quitter");
    }
}