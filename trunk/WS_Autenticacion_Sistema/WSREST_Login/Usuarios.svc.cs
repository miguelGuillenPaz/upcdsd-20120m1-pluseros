using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using WSREST_Login.Dominio;
using WSREST_Login.Persistencia; 

namespace WSREST_Login
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Usuarios" in code, svc and config file together.
    public class Usuarios : IUsuarios
    {
        private UsuarioDAO dao = new UsuarioDAO();

        public Usuario AutenticarUsuario(string usuario, string clave)
        {
            return dao.AutenticarUsuario(usuario, clave);
        }
    }
}
