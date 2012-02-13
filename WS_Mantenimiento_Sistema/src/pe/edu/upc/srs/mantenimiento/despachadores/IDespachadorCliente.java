/**
 *@author Miguel Guillén
**/

package pe.edu.upc.srs.mantenimiento.despachadores;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;;

public interface IDespachadorCliente {

    public int registrarCliente(ClienteDTO cliente);
    public int validarUsuario(String usuario);

}
