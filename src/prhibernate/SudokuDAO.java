/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prhibernate;

import java.util.ArrayList;
import java.util.List;
import model.RankingUserTO;
import pojo.Sudoku;
import pojo.Usuario;

/**
 *
 * @author THOR
 */
public class SudokuDAO {
    
    
    //GESTION DE SUDOKUS
    
    //inserta un sudoku en la bbdd
    public void insertarSudoku(){
        
    }
    
    //retorna un sudoku dada una ID
    public Sudoku getSudokuByID(int idSudoku){
        Sudoku sudoku = new Sudoku();
        return sudoku;
    }
    
    //retorna una lista con todos los sudokus
    public List<Sudoku> getSudokuList(){
        List<Sudoku> sudokus = new ArrayList<>();
        Sudoku sudoku = new Sudoku();
        
        return sudokus;
    }
    
    //GESTION DE USUARIOS
    
    //inserta un usuario nuevo en la DB
    public void insertUser(){
        
    }
    
    //valida el login de un usuario
    public void loginUser(String userName, String pwd){
        
    }
    
    //modifica el perfil de un usuario
    public void modifyUser(){
        
    }
    
    //cambia la pwd de un user
    public void changePwd(){
        
    }
    
    //elimina un usuario
    public void deleteUser(){
        
    }
    
    //GESTION HISTORIAL
    //inserta una partida finalizada en la lista para usuario concreto
    public void updateHistoryOfUserAndSudokuPlayed(Usuario usuario, Sudoku sudoku, float tiempoTotal){
        
    }
    
    //calcula el tiempo medio de juego de un usuario
    public void getAveragePlayTimeOfUser(Usuario usuario){
        
    }
    
    //retorna un sudoku aleatorio al que el usuario aun no ha jugado
    public Sudoku getRandomNoPlayedSudoku(Usuario user){
        Sudoku sudoku = new Sudoku();
        return sudoku;
    }
    
    //retorna el ranking de usuarios menor tiempo primero
    public List<RankingUserTO> rankingUsers(){
        List<RankingUserTO> ranking = new ArrayList<>();
//        RankingUserTO userRanked = new RankingUserTO(userName, 0);
        return ranking;
    }
}
