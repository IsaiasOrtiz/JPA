/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class FabricaConexion {
    private static EntityManagerFactory factory;
    private static final FabricaConexion fabricaConexion = new FabricaConexion();
    
    private FabricaConexion ()
    {
        factory=Persistence.createEntityManagerFactory("JPA_TESTPU");
    }
   public static FabricaConexion getInstance()
   {
       return fabricaConexion;
   }

    public EntityManagerFactory getFactory() {
        return factory;
    }
}
