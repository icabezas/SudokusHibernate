/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.console;
import java.util.List;
import pojo.Sudoku;

/**
 *
 * @author THOR
 */
public class SudokuParser {
    private List<Sudoku> sudokusLeidos;
    private Sudoku sudoku;
    private String sudokuPath;
    
    public void readFile() throws FileNotFoundException, IOException{
        System.out.println("Path: " + sudokuPath);
        try (BufferedReader br = new BufferedReader(new FileReader(sudokuPath))) {
            String[] data;
            String line;
            while ((line = br.readLine()) != null) {
                
                
            }
        }
    }

    public void setSudokuPath(String sudokuPath) {
        this.sudokuPath = sudokuPath;
    }
    
    
}
