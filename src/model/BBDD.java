/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import prhibernate.HibernateUtil;

/**
 *
 * @author THOR
 */
public class BBDD {

    public Session session;
    public Transaction transaction;

    public BBDD() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
}
