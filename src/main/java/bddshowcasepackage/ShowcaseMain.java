package bddshowcasepackage;

import tddshowcasepackage.TimePair;

import java.io.IOException;
import java.util.Scanner;

public class ShowcaseMain {

    public static void main( String[] args ) throws IOException {
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("# ISTQB Advanced Level Agile Technical Tester    #");
        System.out.println("# ISTQB Tester-Training T-Systems International  #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
        ShowcaseMain aShowcaseMain = new ShowcaseMain();
        System.out.println("Version: " +
                            aShowcaseMain.getClass().getPackage().getSpecificationVersion() +
                            " /" +
                            aShowcaseMain.getClass().getPackage().getImplementationVersion());

        String startTime, endTime;

        Scanner aScanner = new Scanner(System.in);
        System.out.print("Gib bitte die Kommen-Zeit ein: "); startTime = aScanner.next();
        System.out.print("Gib bitte die Gehen-Zeit ein: "); endTime = aScanner.next();

        TimePair aTimePair = new TimePair();
        double aTimeDifference = 0.0;
        try {
            aTimeDifference = aTimePair.getTimeDifference(startTime, endTime);
            System.out.format("Die Zeitdifferenz beträgt: " +
                                "%.2f Stunden\n",
                                aTimeDifference);
        }
        catch (TimePair.TimePairException e) {
            System.out.println("Oops, da ist etwas schief gegangen (Error " +
                                e.getMessageNr() +
                                " / " +
                                e.getMessageText());
            return;
        }

        if (aTimeDifference > 10.75) {
            System.out.println("Ruhepause kann nicht berechnet werden, weil das Arbeitszeitgesetz wahrscheinlich verletzt wäre.");
        } else {
            System.out.println("Ich gehe davon aus, dass du kein leitender Angestellter bist...");
            System.out.println("Die gesetzlich vorgeschriebene Ruhepause beträgt " +
                    new Employee("bestes Projekt", EmployeeType.MA).getPauseTime(startTime, endTime) +
                    " Minuten.");
        }
    }
}
