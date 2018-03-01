/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prhibernate;

import exceptions.SudokuExceptions;
import java.io.IOException;
import model.SudokuInjector;
import model.SudokuParser;
import pojo.Sudoku;
import pojo.Usuario;

/**
 *
 * @author THOR
 */
public class PrHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SudokuExceptions {

        System.out.println("Empezando Test con Hibernate");
        System.out.println("Estableciendo conexión");
        SudokuDAO sudokuDAO = new SudokuDAO();
        System.out.println("Conexión establecida");

        //ESTE OBJETO SE ENCARGA DE LEER TODOS LOS SUDOKUS DADA UNA PATH
        SudokuParser parser = new SudokuParser();

        //ESTABLECEMOS LA PATH DEL ARCHIVO
        parser.setSudokuPath("sudokus.txt");

        //LEEMOS EL ARCHIVO
        parser.readFile();

        //INSERTAMOS LA LISTA DE SUDOKUS EN LA BBDD
        //(Mar, si me he olvidado, descomenta este método (lineas 43-46)
        //que cada vez que pruebo se me insertan todos los sudokus en bbdd)
        System.out.println("--- Insertando sudoku ---");
//        for (Sudoku sudoku : parser.sudokusLeidos) {
//            sudokuDAO.insertarSudoku(sudoku);
//        }
//        System.out.println("--- Sudokus insertados ---");

        //BUSCAMOS SUDOKU POR ID
        System.out.println("--- Buscamos sudoku por ID ---");
        int idTest = 915;
        System.out.println(sudokuDAO.getSudokuByID(idTest).toString());

        //OBTENEMOS LISTA CON TODOS LOS SUDOKUS
        System.out.println("--- Listado de sudokus ---");
        for (Sudoku sudoku : parser.sudokusLeidos) {
            System.out.println(sudoku.toString());
        }
        System.out.println("--- TOTAL :  " + parser.sudokusLeidos.size() + " SUDOKUS ---");

        //INSERTAMOS USUARIO
        Usuario user = new Usuario();
        user.setId(0);
        user.setName("Prueba");
        user.setPassword("123456");
        user.setUsername("pruebaName");
        sudokuDAO.insertUser(user);
        System.out.println("--- USUARIO INSERTADO ---");

        //CERRAMOS SESION
        System.out.println("Cerrando sesión");
        sudokuDAO.cerrar();
        System.out.println("Conexión cerrada.");

    }

}
