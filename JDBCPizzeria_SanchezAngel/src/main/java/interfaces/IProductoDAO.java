/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;
import objetos.Producto;

/**
 *
 * @author angelsn
 */
public interface IProductoDAO {
    public boolean agregar(Producto producto);
    public boolean actualizar(Producto producto);
    public boolean eliminar(int id);
    public Producto consultar(int id);
    public List<Producto> consultar();
}
