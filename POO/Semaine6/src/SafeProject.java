import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class SafeProject {

    private final static int NB_PROJECTS = 3;

    public static void main(String[] args) {
        ArrayList<Project> projects = new ArrayList<Project>();

        do {
            Project project = new Project();
            project.readProject();
            projects.add(project);
        } while (projects.size() < NB_PROJECTS);
    }

}

class Project {

    private String name = null;
    private String subject = null;
    private int duration = -1;

    public Project() {}

    public void readProject() {
        Scanner scanner = new Scanner(System.in);
        do{
           try {
               System.out.println("Donnez le nom du projet : ");
               name = scanner.nextLine();
               if(name.length() > 50){
                   throw new NameTooLongException("Le nom du projet ne doit pas dépasser 50 caractères !");
               }
           }
           catch (NameTooLongException e){
               System.out.println(e.getMessage());
           }
        }while(name.length() > 50);

        do{
            try {
                System.out.println("Donnez le sujet du projet : ");
                subject = scanner.nextLine();
                if(subject.length() > 50){
                    throw new NameTooLongException("Le sujet du projet ne doit pas dépasser 50 caractères !");
                }
            }
            catch(NameTooLongException e){
                System.out.println(e.getMessage());
            }
        }while(subject.length() > 50);

        do{
            try {
                System.out.println("Donnez la durée du projet : ");
                duration = Integer.parseInt(scanner.nextLine());
                if(duration < 0){
                    throw new WrongDurationException("La durée du projet doit être positive !");
                }
            }
            catch (NumberFormatException e){
                System.out.println("La durée du projet doit être un entier postif !");
            }
            catch (WrongDurationException e){
                System.out.println(e.getMessage());
            }
        }while(duration < 0);


    }

}

class WrongDurationException extends Exception {
    public WrongDurationException(String message){
        super(message);
    }
}

class NameTooLongException extends Exception {
    public NameTooLongException(String message){
        super(message);
    }
}