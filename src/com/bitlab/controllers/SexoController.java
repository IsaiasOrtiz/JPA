/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controllers;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.SrhSxSexo;
import javax.persistence.EntityManager;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SexoController extends AbstractController<SrhSxSexo>{

    public SexoController() {
        super(SrhSxSexo.class);
    }

    @Override
    protected EntityManager manejadorDeEntidades() {
        return FabricaConexion.getInstance().getFactory().createEntityManager();
    }
    
}
