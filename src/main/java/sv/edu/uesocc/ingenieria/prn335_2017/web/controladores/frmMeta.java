/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.AbstractInterface;

import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.MetaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Meta;

/**
 *
 * @author juancarlos
 */
@Named(value = "frmMeta")
@ViewScoped
public class frmMeta extends GenericMB<Meta> implements Serializable{

    public frmMeta() {
    }

    @EJB
    MetaFacadeLocal facade;
    Meta metaEntity;
    boolean btnVisible=false;
    
    boolean btnadd = false;
    boolean botones = false;
    boolean botones2 = false;
    

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public MetaFacadeLocal getFacade() {
        return facade;
    }

    public boolean isBtnVisible() {
        return btnVisible;
    }

    public void setBtnVisible(boolean btnVisible) {
        this.btnVisible = btnVisible;
    }
    
    public void setFacade(MetaFacadeLocal facade) {
        this.facade = facade;
    }

    public Meta getMetaEntity() {
        return metaEntity;
    }

    public void setMetaEntity(Meta metaEntity) {
        this.metaEntity = metaEntity;
    }

    public List<Meta> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Meta> listaDatos) {
        this.listaDatos = listaDatos;
    }
    
    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    public boolean isBotones2() {
        return botones2;
    }

    public void setBotones2(boolean botones2) {
        this.botones2 = botones2;
    }
    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    public Meta getEntity() {
        return metaEntity;
    }

    @Override
    protected AbstractInterface<Meta> getFacadeLocal() {
        return facade;
    }

    @Override
    public void editar() {
        super.editar();
        this.botones = false;
        this.botones2 = false;
        this.btnadd = false;
        reiniciarValores();
    }

    @Override
    public void eliminar() {
        super.eliminar();
        this.botones = false;
        this.botones2 = false;
        this.btnadd = false;
        reiniciarValores();
    }

    @Override
    public void crear() {
        super.crear(); 
        reiniciarValores();
    }
    // </editor-fold>
    
    @PostConstruct
    public void init(){
        llenarLista();
    }
    
    
    public void onRowSelect(SelectEvent event) {
        btnVisible = true;
    }
    
    public void btnCancelar() {
        metaEntity = new Meta();
        this.botones=false;
        this.btnadd=false;
        this.botones2=false;
    }
    
    public void nuevo(){
    metaEntity = new Meta();
    this.botones = true;
    this.btnadd = true;
    this.botones2=false;
    }
    
    public void reiniciarValores(){
        metaEntity.setActivo(false);
        metaEntity.setDescripcion(null);
        metaEntity.setIdMeta(null);
        metaEntity.setNombre(null);
    }
    
    public void cambiarSeleccion() {
        this.botones = false;
        this.btnadd = true;
        this.botones2=true;

    }
}
