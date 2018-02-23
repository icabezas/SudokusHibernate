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
import java.util.ArrayList;
import java.util.List;
import pojo.Sudoku;

/**
 *
 * @author THOR
 */
public class SudokuParser {

    public List<Sudoku> sudokusLeidos;
    private Sudoku sudoku;
    private String sudokuPath;

    public void readFile() throws FileNotFoundException, IOException {
        sudoku = new Sudoku();
        sudokusLeidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sudokuPath))) {
            String line;
            String[] data;
            String sudokuDescription;
            
            //LEE TRES LINEAS A.K.A. UN SUDOKU ENTERO CADA ITERACIÓN
            while ((line = br.readLine()) != null) {
                data = line.split(" ");
                if (data[0].equals("%")) {
                    sudoku.setNivel(Integer.parseInt(data[1]));
                    sudokuDescription = data[2] + " " + data[3] + " " + data[4];
                    sudoku.setDescripcion(sudokuDescription);
                    line = br.readLine();
                    sudoku.setProblema(line);
                    line = br.readLine();
                    sudoku.setSolucion(line);
                    sudokusLeidos.add(sudoku);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    //SOLO PARA DEBUGGEAR. MUESTRA LOS DATOS DE LOS SUDOKUS LEIDOS
    public void showSudokus() {
        for (Sudoku s : sudokusLeidos) {
            System.out.println(s.toString());
        }
    }

    //ESTABLECE LA RUTA DEL FICHERO A LEER
    public void setSudokuPath(String sudokuPath) {
        this.sudokuPath = sudokuPath;
    }

}
