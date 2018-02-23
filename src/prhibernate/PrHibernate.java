/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prhibernate;

import java.io.IOException;
import model.SudokuParser;

/**
 *
 * @author THOR
 */
public class PrHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        SudokuParser parser = new SudokuParser();
        parser.setSudokuPath("sudokus.txt");
        parser.readFile();
    }
    
}
