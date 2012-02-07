using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using WSREST_Login.Dominio;
using WSREST_Login.Persistencia;
using System.ServiceModel.Web; 

namespace WSREST_Login
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IUsuarios" in both code and config file together.
    [ServiceContract]
    public interface IUsuarios
    {

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "Login?usuario={usuario}&clave={clave}", ResponseFormat = WebMessageFormat.Json)]
        Usuario AutenticarUsuario(string usuario, string clave);
        
    }
}
