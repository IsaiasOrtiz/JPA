/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.jpa_test;

import com.bitlab.controllers.EmpleadoController;
import com.bitlab.controllers.SexoController;
import com.bitlab.entidades.SrhEpEmpleado;
import com.bitlab.entidades.SrhSxSexo;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class JPA_TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        SrhSxSexo e =new SrhSxSexo();
//        EntityManagerFactory en=Persistence.createEntityManagerFactory("JPA_TESTPU");
//        EntityManager enm= en.createEntityManager();
//        enm.getTransaction().begin();
//        String jpql="SELECT s FROM SrhEpEmpleado s";
//        Query q =enm.createQuery(jpql);
            SexoController sx=new SexoController();
                    
        List<SrhSxSexo> emp=sx.encontarTodos();
        for (SrhSxSexo s : emp) {
            System.out.println(s.getSxNombre());
        }
            
            
        
        
    }

}
