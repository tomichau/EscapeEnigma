class Test extends Program{
    boolean quitter = false;
    String[] sauvegardes = new String[]{"Liste Sauvegardes :"};
    int progression = 0;
    String logo = fileAsString("./image/logoJeu.txt");
    String manoir = fileAsString("./image/manoir.txt");
    String fantomeAngry = fileAsString("./image/fantomeAngry.txt");
    String fantomeGentil = fileAsString("./image/fantomeGentil.txt");

    void algorithm(){ 
        clearScreen();
        startGame();
    }
    
    void startGame(){ // BOUHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        while(!quitter){
            menu();
            debut();
            salleActuel();
        }
        boolean sauvegardePartie = false;
        while(!sauvegardePartie){
            println("Voulez-vous sauvegarder votre progression actuel ? Oui / Non :");
            String choix = readString();
            if(choix == "Oui"){
                println("Sauvegarde faites");
                sauvegardePartie = true;
            }else{
                println("Êtes-vous sur ? Oui / Non :");
                choix = readString();
                if(choix == "Oui"){
                    println("Votre partie n'a pas été sauvegardé.");
                    sauvegardePartie = true;
                }
            }
        }
    }

    void menu(){
        println(logo);
        boolean choixConfirmer = false;
        while(!choixConfirmer){
            println(logo);
            String choix = readString();
            if(equals(choix, "1")){
                clearScreen();
                choixConfirmer = true;
            }else if(equals(choix, "2")){
                println("Veuillez choisir un nom pour votre partie");
                String nom = readString();
                sauvegardes = genereSauvegarde(sauvegardes, nom);
                choixConfirmer = true;
            }else if(equals(choix, "3")){
                quitter = true;
                choixConfirmer = true;
            }else if(equals(choix, "666")){
                clearScreen();
                println(fileAsString("./image/tetedemort.txt"));
                delay(666);
            }else{
                println("Veuillez entrer une valeur valide !");
            }
        }
    }
    String[] genereSauvegarde(String[] tab, String nom){
        String[] tabSauvegardes = new String[length(tab) + 1];
        for(int i = 0; i < length(tab); i += 1){
            tabSauvegardes[i] = tab[i];
        }
        tabSauvegardes[length(tabSauvegardes)-1] = nom;
        return tabSauvegardes;
    }

    void debut(){
        println(manoir);
        println(fileAsString("./image/contexte.txt"));
        println("Suivant");
        if(!equals(readString(), null)){
            clearScreen();
            println(fantomeAngry);
            println("bouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuh");
            delay(2000);
            clearScreen();
            println(fantomeGentil);
            println("et non je suis gentil en faite ahahah");
            delay(2000);
            clearScreen();
            salleActuel();
        }
    }

    void salleActuel(){
        if(progression == 0){
            hall();
        }else if(progression == 1){
            anglais();
        }else if(progression == 2){
            sciences();
        }else if(progression == 3){
            histoire();
        }else if(progression == 4){
            theEnd();
        }
    }

    void hall(){
        // Faire le texte d'entre dans le manoir (passage qui se referme);
        println(fantomeGentil);
        println("Vous êtes maintenant enfermé dans ce manoir et votre seul moyen d'en sortir est de réussir toute les épreuves 
                qui s'y trouvent, chaque salle sera sur le thème d'une matière scolaire ! Je sens que vous êtes plutôt doué donc vous 
                devrier y arriver assez facilement non ?");
        progression += 1;
    }

    void anglais(){
        println(fileAsString("./image/monsieurGentil.txt"));
        println("Bienvenue dans la première salle de ce magnifique manoir !");
        println("Comme tu le sais, chaque salle représente une matière, et celle-ci représente l'anglais !");

    }

    void sciences(){
        println("coucou");
    }

    void histoire(){
        println("coucou");
    }
    
    void theEnd(){
        println("coucou");
    } 
}