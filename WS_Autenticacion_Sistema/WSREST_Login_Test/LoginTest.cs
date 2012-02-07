using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;
using System.IO;
using System.Web.Script.Serialization; 


namespace WSREST_Login_Test
{
    [TestClass]
    public class LoginTest
    {
        [TestMethod]
        public void CRUDTest()
        {

            // Prueba de Obtencion Alumno via HTTP GET
            HttpWebRequest req = (HttpWebRequest)WebRequest.Create("http://localhost:1838/Usuarios.svc/Login?usuario=Fred&clave=Casas");
            req.Method = "GET";
            HttpWebResponse res = (HttpWebResponse)req.GetResponse();
            StreamReader reader = new StreamReader(res.GetResponseStream());
            String UsuarioJson = reader.ReadToEnd();
            JavaScriptSerializer js = new JavaScriptSerializer();
            Usuario UsuarioObtenido = js.Deserialize<Usuario>(UsuarioJson);

            Assert.AreEqual("Fred", UsuarioObtenido.usuario);
            Assert.AreEqual(1, UsuarioObtenido.tipo_usuario);
            Assert.AreEqual(1, UsuarioObtenido.estado);
            Assert.AreEqual("Freddy Casas Herrera", UsuarioObtenido.nombre);
            Assert.AreEqual("freddycasas@gmail.com", UsuarioObtenido.email);
        }
    }
}
