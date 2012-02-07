using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace WSREST_Login.Dominio
{
    [DataContract]
    public class Usuario
    {

        [DataMember]
        public string usuario { get; set; }

        [DataMember]
        public int tipoUsuario { get; set; }

        [DataMember]
        public int estado { get; set; }

        [DataMember]
        public string nombre { get; set; }

        [DataMember]
        public string email { get; set; }

    }
}