package sn26004.torreshanoi;

import java.util.Scanner;
import java.util.Stack; 
        
public class SN26004TorresHanoi {
    
    //Declare the attributes
    
    private static Stack<Integer>[] torres;
    private static int movimientos;
    private static int discos;
    private static Scanner scanner = new Scanner(System.in);    

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("ENTER THE NUMBERS OF DISCS (RECOMENDED: 3 - 7): ");
        discos = scanner.nextInt();
        
        //Conditional to asign number of stacks
        if(discos < 1) discos = 3;
        
        //Start up the towers
        torres = new Stack[3]; //Create an array of 3 elements of type Stack
        for (int i = 0; i < 3; i++) {
            
            torres[i] = new Stack<>(); //initializes each element of the array with a stack
        
        }
        
        //Place the discs on the first tower
        for (int i = discos; i >= 1; i--){
            
            /*
            - Place the disc by his number of the stack (tower)
            - Size of the disc has determinated by his initial location
            - It is lited from highest to lower to make it easier to draw them 
            - The firts disc (discs) is bigger, the last one (1) is smaller
            */
            torres[0].push(i);          
        
        }
        
        //Show the towers
        
        movimientos = 0;
        mostarTorres();
        
    } 
    
    private static void mostrarTorres() {
    
        //Use ASCII characters to draw the towers and discs
        
        final String ESPACIO = " ";
        final String IGUAL = "=";
        final String GUION = "-";
        final String BARRA = "|";
        System.out.println("\nCurrent status (Moves: " + movimientos + " )");
        
        for(int nivel = discos; nivel >= 0; nivel--){
            for (int torre = 0; torre < 3; torre++){
                if (torres[torre].size() > nivel){
                    int numDisco = torres[torre].get(nivel);
                        System.out.print(ESPACIO.repeat(discos - numDisco)+ IGUAL.repeat(numDisco * 2 + 1) + ESPACIO.repeat(discos) + BARRA + ESPACIO.repeat(discos));
                }
                
                System.out.print(ESPACIO.repeat(3));
            }
        }
        
    }
    
}
