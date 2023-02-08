import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String[] row1 = {" ", "|", " ", "|", " "};
    static String[] row2 = {"-", "+", "-", "+", "-"};
    static String[] row3 = {" ", "|", " ", "|", " "};
    static String[] row4 = {"-", "+", "-", "+", "-"};
    static String[] row5 = {" ", "|", " ", "|", " "};

    static String sign;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> rows = new ArrayList<>();


    public static void main(String[] args) {
        int player = 1;
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);

        
        while (!hasWon(sign)) {
            int rowChoice;
            int indexChoice;
            printBoard(rows);
            do {
            System.out.println("Pick a row (1-3): ");
            rowChoice = scanner.nextInt();

            }while (rowChoice != 1 && rowChoice  != 2 && rowChoice != 3);

            do {
            System.out.println("Choose a field (1-3): ");
            indexChoice = scanner.nextInt();

            }while (indexChoice != 1 && indexChoice != 2 && indexChoice != 3);

            if (player % 2 == 0){
                sign = "O";
            } else {
                sign = "X";
            }

            setMark(rowChoice, indexChoice);

            player++;
        }
        gameOver(sign);
    }

    public static void printBoard(ArrayList<String[]> rows){
        for (String[] s : rows){
            for (int i = 0; i < s.length; i++){
                System.out.print(s[i]);
            }
            System.out.println();
        }

    }

    public static void setMark(int rowChoice, int indexChoice){
        switch (rowChoice) {
            case 1:
                if (indexChoice == 1) row1[0] = sign;
                if (indexChoice == 2) row1[2] = sign;
                if (indexChoice == 3) row1[4] = sign;
                break;
            case 2:
                if (indexChoice == 1) row3[0] = sign;
                if (indexChoice == 2) row3[2] = sign;
                if (indexChoice == 3) row3[4] = sign;
                break;
            case 3:
                if (indexChoice == 1) row5[0] = sign;
                if (indexChoice == 2) row5[2] = sign;
                if (indexChoice == 3) row5[4] = sign;
                break;
        }
    }

    public static boolean isUsed(){


        return false;
    }
    
    public static void gameOver(String sign){
        System.out.println("#######################");
        System.out.println("GAME OVER!");
        System.out.println("#######################");
        printBoard(rows);
        System.out.println("#######################");
        if (sign.equalsIgnoreCase("X")){
            System.out.println("Cross won!");
        } else {
            System.out.println("Circle won!");
        }
        System.out.println("#######################");
    }

    public static boolean hasWon(String sign){
        //First row
        if (row1[0].equalsIgnoreCase(sign) &&
            row1[2].equalsIgnoreCase(sign) &&
            row1[4].equalsIgnoreCase(sign)){
            return true;
        }
        //Second row
        if (row3[0].equalsIgnoreCase(sign) &&
            row3[2].equalsIgnoreCase(sign) &&
            row3[4].equalsIgnoreCase(sign)){
            return true;
        }
        //Third row
        if (row5[0].equalsIgnoreCase(sign) &&
            row5[2].equalsIgnoreCase(sign) &&
            row5[4].equalsIgnoreCase(sign)){
            return true;
        }
        //First column
        if (row1[0].equalsIgnoreCase(sign) &&
            row3[0].equalsIgnoreCase(sign) &&
            row5[0].equalsIgnoreCase(sign)){
            return true;
        }
        //Second column
        if (row1[2].equalsIgnoreCase(sign) &&
            row3[2].equalsIgnoreCase(sign) &&
            row5[2].equalsIgnoreCase(sign)){
            return true;
        }
        //Third column
        if (row1[4].equalsIgnoreCase(sign) &&
            row3[4].equalsIgnoreCase(sign) &&
            row5[4].equalsIgnoreCase(sign)){
            return true;
        }
        //First cross
        if (row1[0].equalsIgnoreCase(sign) &&
            row3[2].equalsIgnoreCase(sign) &&
            row5[4].equalsIgnoreCase(sign)){
            return true;
        }
        //Second cross
        if (row1[4].equalsIgnoreCase(sign) &&
            row3[2].equalsIgnoreCase(sign) &&
            row5[0].equalsIgnoreCase(sign)){
            return true;
        }

        //else...
        return false;
    }
}