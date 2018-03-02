/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prhibernate;

import exceptions.SudokuExceptions;
import java.util.ArrayList;
import java.util.List;
import model.RankingUserTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Historial;
import pojo.Sudoku;
import pojo.Usuario;

/**
 *
 * @author THOR
 */
public class SudokuDAO {

    private Session sesion;
    private Transaction tx;
    //GESTION DE SUDOKUS

    public SudokuDAO() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    public void insertarSudoku(Sudoku sudoku) throws SudokuExceptions {
        if (existSudoku(sudoku)) {
            System.out.println("Ya existe este sudoku " + sudoku.getId());
        }
        tx = sesion.beginTransaction();
        sesion.save(sudoku);
        tx.commit();
    }

    //comprueba si el sudoku ya existe en la bbdd
    public boolean existSudoku(Sudoku sudoku) {
        return getSudokuByID(sudoku.getId()) != null;
    }

    //retorna un sudoku dada una ID
    public Sudoku getSudokuByID(int idSudoku) {
        return (Sudoku) sesion.get(Sudoku.class, idSudoku);
    }

    //retorna una lista con todos los sudokus
    public List<Sudoku> getSudokuList() {
        Query q = sesion.createQuery("select c from Sudoku c");
        return q.list();
    }

    //GESTION DE USUARIOS
    //inserta un usuario nuevo en la DB
    public void insertUser(Usuario user) {
        if (existsUser(user)) {
            System.out.println("Ya existe este user " + user.getId());
        } else {
            tx = sesion.beginTransaction();
            sesion.save(user);
            tx.commit();
            System.out.println("--- USUARIO INSERTADO ---");
        }
    }

    //mira si ya existe el usuario
    public boolean existsUser(Usuario user) {
        System.out.println(user.toString());
        return getUserByID(user.getId()) != null;
    }

    //retorna un user dada una ID
    public Usuario getUserByID(int idUser) {
        return (Usuario) sesion.get(Usuario.class, idUser);
    }

    //valida el login de un usuario
    public boolean loginUser(String userName, String pwd) {
        Query query = sesion.createQuery("from Usuario where username = :username and password = :password ");
        query.setParameter("username", userName);
        query.setParameter("password", pwd);
        List list = query.list();
        if (!list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //modifica el perfil de un usuario
    public void modifyUser(Usuario user, String newName) throws SudokuExceptions {
        Usuario aux = (Usuario) sesion.get(Usuario.class, user.getId());
        if (aux != null) {
            aux.setName(newName);
            tx = sesion.beginTransaction();
            sesion.update(aux);
            tx.commit();
            System.out.println("--- USUARIO MODFICADO ---");
        } else {
            throw new SudokuExceptions("No existe usuario");
        }
    }

    //cambia la pwd de un user
    public void changePwd(Usuario user, String newPwd) throws SudokuExceptions {
        Usuario aux = (Usuario) sesion.get(Usuario.class, user.getId());
        System.out.println(user.toString());
        if (aux != null) {
            aux.setPassword(newPwd);
            tx = sesion.beginTransaction();
            sesion.update(aux);
            tx.commit();
            System.out.println("--- PASSWORD MODFICADA ---");
        } else {
            throw new SudokuExceptions("No existe usuario");
        }
    }

    //elimina un usuario
    public void deleteUser(Usuario user) throws SudokuExceptions {
        Usuario aux = (Usuario) sesion.get(Usuario.class, user.getId());
        if (aux != null) {
            tx = sesion.beginTransaction();
            sesion.delete(aux);
            tx.commit();
            System.out.println("--- USUARIO BORRADO ---");
        } else {
            throw new SudokuExceptions("No existe el usuario");
        }
    }

    //GESTION HISTORIAL
    //inserta una partida finalizada en la lista para usuario concreto
    public void updateHistoryOfUserAndSudokuPlayed(Usuario user, Sudoku sudoku, double tiempoTotal) {
        Historial historial = new Historial();
        historial.setId(1);
        historial.setIdSudoku(sudoku.getId());
        historial.setIdUser(user.getId());
        historial.setTimePlayed(tiempoTotal);
        tx = sesion.beginTransaction();
        sesion.save(historial);
        try {
            tx.commit();
        }catch(Exception ex){
            throw ex;
        }
        System.out.println("--- HISTORIAL DE JUEGO MODIFICADO---");
    }

//calcula el tiempo medio de juego de un usuario
    public void getAveragePlayTimeOfUser(Usuario usuario) {

    }

    //retorna un sudoku aleatorio al que el usuario aun no ha jugado
    public Sudoku getRandomNoPlayedSudoku(Usuario user) {
        Sudoku sudoku = new Sudoku();
        return sudoku;
    }

    //retorna el ranking de usuarios menor tiempo primero
    public List<RankingUserTO> rankingUsers() {
        List<RankingUserTO> ranking = new ArrayList<>();
//        RankingUserTO userRanked = new RankingUserTO(userName, 0);
        return ranking;
    }

    public void cerrar() {
        sesion.close();
        HibernateUtil.close();
    }
}
