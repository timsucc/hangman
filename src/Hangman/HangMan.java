/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;

/**
 *
 * @author timsucc
 */

//* Class HangMan
public class HangMan {

    //* Declaer private int fault
    private int fault;

    //* Public constructer HangMan(): 這段虛擬碼以不用寫
    public HangMan() {

        //* Set fault = 0
        fault = 0;

    }//* End constructor

    
    //* Public Moidule setFault(int inpFault)
    public void setFault(int inpFault){
        
        //* Set fault = inpFault
        fault = inpFault;
        
    }//* End module
    
    //* Public function int getFault
    public int getFault(){
        
        //* Return fault
        return fault;        
        
    }//* End function
    
    //* Public Module showHangMan
    public void showHnagMan() {

        //* If fault > 6 then
        if (fault > 6) {
            
            //* Set fault = 6
            fault = 6;
            
        }//* End if

        
        //* For index = 0 to fault - 1
        for (int i = 1; i <= fault; i++) {

            //* Select index
            switch (i) {

                //* Case 1:
                case 1:

                    //* Display "\"
                    System.out.print("\\");

                    break;

                //* Case 2:
                case 2:

                    //* Diaplay "O"
                    System.out.print("O");

                    break;

                //* Case 3:
                case 3:

                    //* Display "/"
                    System.out.print("/");

                    break;

                //* Case 4:    
                case 4:

                    //* Display "\n |"
                    System.out.print("\n | ");

                    break;

                //* Case 5:
                case 5:

                    //* Display "\n/"
                    System.out.print("\n/");

                    break;

                //* Case 6:
                case 6:

                    //* Display "\"
                    System.out.print(" \\");

                    break;

            }

        }

        System.out.println(""); // 純粹排版好看而已
        
    }//* End Module

}//* End class
