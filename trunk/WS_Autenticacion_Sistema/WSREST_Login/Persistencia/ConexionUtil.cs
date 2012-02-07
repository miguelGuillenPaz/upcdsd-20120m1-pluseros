using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WSREST_Login.Persistencia
{
    public class ConexionUtil
    {
        public static string cadena
        {
            get
            {
                   return "Server=10.175.57.162;Database=srs;Uid=root;Pwd=mysql;";
            }
        }
    }
}