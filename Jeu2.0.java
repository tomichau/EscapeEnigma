import extensions.File;
import extensions.CSVFile;

class Jeu extends Program{
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
    
    void startGame(){ 
        while(!quitter){
            menu();
            debut();
            salleActuel();
            println("Après avoir écouté ce mystérieux fantôme vous expliquer comment faire pour s'échapper de cet endroit,");
            println("vous et vous amis décidaient de vous diriger vers la seul porte disponnible.");
            println("Vous entrez dans une sombre pièce, et au bout de quelques secondes, les lumières s'allument et un");
            println("une personne s'y tiens en son centre.");
            salleActuel();
            theEnd();
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
            println("Suivant");
            if(!equals(readString(), null)){
                clearScreen();
                println(fantomeGentil);
                println("et non je suis gentil en faite ahahah");
                println("Suivant");
                if(!equals(readString(), null)){
                    clearScreen();
                }
            }
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
        println("Vous êtes maintenant enfermé dans ce manoir et votre seul moyen d'en sortir est de réussir toute les épreuves");
        println("qui s'y trouvent, chaque salle sera sur le thème d'une matière scolaire ! Je sens que vous êtes plutôt doué donc vous");
        println("devrier y arriver assez facilement non ?");
        println("Suivant");
        if(!equals(readString(), null)){
            progression += 1;
            clearScreen();
        }
    }

    void anglais(){
        println(fileAsString("./image/monsieurGentil.txt"));
        println("Bienvenue dans la première salle de ce magnifique manoir !");
        println("Comme tu le sais déjà, chaque salle représente une matière, et celle-ci représente l'anglais !");
        println("Et c'est moi qui superviserai cette première épreuve. Commençons directement si tu es prêt");
        String[][] questions = creationTableQuestion("./question/anglais.csv");
        int points = 0;
        String question = "";
        String reponse = "";
        println("Vous devez traduire les mots donnés en Anglais !");
        println("N'oubliez pas de mettre une majuscule au début de votre mot et de ne pas mettre d'espace !");
        for(int i = 0; i < length(questions); i += 1){
            question = questions[i][0];
            reponse = questions[i][1];
            println("Traduisez : " + question + " : ");
            String reponseJoueur = readString();
            if(equals(reponseJoueur, reponse)){
                println("Bonne réponse, +1 point !");
                points += 1;
            }else{
                println("Aie... Mauvaise réponse, la réponse était : " + reponse);
            }
        }
        if(points >= 15){
            println("Félicitations, vous avez réussi avec un total de " + points + " points !");
        }else{
            println("Dommage, il vous fallait au minimum 15 points pour réussir et vous en avez eu : " + points);
        }
    }

    String[][] creationTableQuestion(String cheminFichier){
        CSVFile table = loadCSV(cheminFichier);
        int nombreLigne = rowCount(table);
        int nombreColonne = columnCount(table);
        String[][] contenuTable = new String[nombreLigne][nombreColonne];
        for(int idxLigne = 0; idxLigne < nombreLigne; idxLigne += 1){
            for(int idxColonne = 0; idxColonne < nombreColonne; idxColonne += 1){
                contenuTable[idxLigne][idxColonne] = getCell(table, idxLigne, idxColonne);
            }
        }
        return contenuTable;
    }

    String[][] questAlea(String[][] table){
        print("cc");
    }


    void sciences(){
        boolean reussi = false;
        int points = 0;
        String[] elements = new String[]{"Hydrogène", "Hélium", "Carbone", "Azote", "Oxygène", 
                                         "Fluor", "Néon", "Sodium", "Magnésium", "Aluminium", 
                                         "Silicium", "Phosphore", "Soufre", "Chlore", "Potassium", 
                                         "Calcium", "Fer", "Cuivre", "Zinc", "Or"};
        int tentatives = 5;
        println("expliquer le but du jeu");
        //toString(elements);
        //delay(1000); // a modifier je peux pas tester vu que je suis sous windows..
        for(int i = 1; i <= 5; i += 1){
            println("tour actuel : tour " + i);
            int random = (int) (random() * 20);
            String eltAtrouver = elements[random];
            String mot = transfoMot(eltAtrouver);
            boolean trouver = false;
            while(tentatives > 0 || trouver == false){
                println("Il vous reste actuellement " + tentatives + " tentatives.");
                println("Mot actuel : " + mot);
                // choix lettre et verif si lettre in mot initiale :
                println("Choississez un caractère : ");
                char caract = readChar();
                boolean verif = lettreDansMot(eltAtrouver, caract);
                if(verif == true){
                    mot = rajoutCaract(eltAtrouver, mot, caract);
                    if(equals(mot, eltAtrouver)){
                        trouver = true;
                    }
                }else{
                    tentatives -= 1;
                }
                if(tentatives <= 0){
                    println("Perdu le mot à trouver était : " + eltAtrouver);
                    println("Vous ne gagnez pas de points dommage...");
                }else if(trouver == true){
                    println("Félicitation, vous avez trouver le mot !");
                    println("Eh un point en plus !");
                    points += 1;
            }
        }
        if(points >= 3){
            println("Vous avez réussi cette matière avec un total de " + points + "sur 5 ! Félicitation !");
            reussi = true;
        }else{
            println("... Vous n'avez pas réussi... je vous laisse quand même accéder à la salle suivante parce que vous avez fait l'effort de jouer mais bon...");
            println("Essayer de ne pas faire la même chose dans les salles suivantes.");
        }
    }

    String transfoMot(String mot){
        String motEtoile = "";
        for(int i = 0; i < length(mot); i += 1){
            motEtoile += "*";
        }
        return motEtoile;
    }

    boolean lettreDansMot(String motInitiale, char car){
        boolean lettreIn = false;
        for(int i = 0; i < length(motInitiale); i += 1){
            char lettre = charAt(motInitiale, i);
            if(lettre == car){
                lettreIn = true;
            }
        }
        return lettreIn;
    }

    String rajoutCaract(String motInitiale, String motEtoile, char caract){
        String motAvecCaract = "";
        for(int i = 0; i < length(motInitiale); i += 1){
            char lettreInitiale = charAt(motInitiale, i);
            char lettreEtoile = charAt(motEtoile, i);
            if(lettreInitiale == caract){
                motAvecCaract += caract;
            }else{
                motAvecCaract += lettreEtoile;
            }
        }
        return motAvecCaract;
    }

    /*void toStringScience(String[] tab){
        String liste = "";
        int indice = 0;
        for(int i = 0; i < 4; i += 1){
            liste = "";
            for(int x = 0; x < 5; x += 1){
                liste += tab[indice];
                indice += 1;
            }
            println(liste);
        }
    }*/

    void histoire(){
        println("coucou");
    }
    
    void theEnd(){
        quitter = true;
    } 

}
