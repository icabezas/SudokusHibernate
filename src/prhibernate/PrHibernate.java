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
        //(Mar, si me he olvidado, descomenta este método (lineas 44-47)
        //que cada vez que pruebo se me insertan todos los sudokus en bbdd)
        System.out.println("--- Insertando sudokus ---");
//        for (Sudoku sudoku : parser.sudokusLeidos) {
//            sudokuDAO.insertarSudoku(sudoku);
//        }
//        System.out.println("--- Sudokus insertados ---");

        //BUSCAMOS SUDOKU POR ID
        System.out.println("--- Buscamos sudoku por ID ---");
        //aqui la id de prueba, cambiar a la que sea conveniente segun la BBDD
        int idTest = 915;
        System.out.println(sudokuDAO.getSudokuByID(idTest).toString());

        //OBTENEMOS LISTA CON TODOS LOS SUDOKUS
        //otra vez, si no he descomentado esto es que se me ha olvidado, linea 57-59
//        System.out.println("--- Listado de sudokus ---");
//        parser.showSudokus();
//        System.out.println("--- TOTAL :  " + parser.sudokusLeidos.size() + " SUDOKUS ---");
        //CREAMOS USUARIO DE PRUEBA
        Usuario user = new Usuario();
        user.setId(2);
        user.setName("Prueba");
        user.setPassword("123456");
        user.setUsername("pruebaName");

//        //INSERTAMOS USUARIO
        //otra vez, si no he descomentado esto es que se me ha olvidado, linea 67
        sudokuDAO.insertUser(user);

        //VALIDAMOS LOGIN USUARIO
        System.out.println("--- LOGIN USUARIO ---");
        boolean login = sudokuDAO.loginUser(user.getUsername(), user.getPassword());
        if (login) {
            System.out.println("--- usuario logeado ---");
        } else {
            System.out.println("--- login fallido ---");
        }

        //MODIFICAMOS DATOS DE USUARIO
        System.out.println("--- MODIFICANDO USUARIO ---");
//        sudokuDAO.modifyUser(user, "Prueba2");

        //CAMBIAMOS CONTRASEÑA DE USUARIO
        System.out.println("--- MODIFICANDO USUARIO ---");
//        sudokuDAO.changePwd(user, "Prueba2");

        //ELIMINAMOS USUARIO
        System.out.println("--- BORRANDO USUARIO ---");
//        sudokuDAO.deleteUser(user);

        //INSERTAMOS PARTIDA FINALIZADA EN EL HISTORIAL DEL USUARIO
        Sudoku sudoku = parser.sudokusLeidos.get(1);
        Usuario userTest = new Usuario(3, "TestHistorial", "testing", "123");
        sudokuDAO.insertUser(userTest);
        
        double time = 12;
        try {
            sudokuDAO.updateHistoryOfUserAndSudokuPlayed(userTest, sudoku, time);
        }catch(Exception ex){
            throw ex;
        }

        //CERRAMOS SESION
        System.out.println("Cerrando sesión");
        sudokuDAO.cerrar();
        System.out.println("Conexión cerrada.");

    }

}
