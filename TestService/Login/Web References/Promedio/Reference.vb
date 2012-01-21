﻿'------------------------------------------------------------------------------
' <auto-generated>
'     This code was generated by a tool.
'     Runtime Version:2.0.50727.1433
'
'     Changes to this file may cause incorrect behavior and will be lost if
'     the code is regenerated.
' </auto-generated>
'------------------------------------------------------------------------------

Option Strict Off
Option Explicit On

Imports System
Imports System.ComponentModel
Imports System.Diagnostics
Imports System.Web.Services
Imports System.Web.Services.Protocols
Imports System.Xml.Serialization

'
'This source code was auto-generated by Microsoft.VSDesigner, Version 2.0.50727.1433.
'
Namespace Promedio
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433"),  _
     System.Diagnostics.DebuggerStepThroughAttribute(),  _
     System.ComponentModel.DesignerCategoryAttribute("code"),  _
     System.Web.Services.WebServiceBindingAttribute(Name:="serviciosSoap", [Namespace]:="http://tempuri.org/")>  _
    Partial Public Class servicios
        Inherits System.Web.Services.Protocols.SoapHttpClientProtocol
        
        Private GetMessageOperationCompleted As System.Threading.SendOrPostCallback
        
        Private CalculaPromedioOperationCompleted As System.Threading.SendOrPostCallback
        
        Private LoginOperationCompleted As System.Threading.SendOrPostCallback
        
        Private EjecutarLoginOperationCompleted As System.Threading.SendOrPostCallback
        
        Private useDefaultCredentialsSetExplicitly As Boolean
        
        '''<remarks/>
        Public Sub New()
            MyBase.New
            Me.Url = Global.Login.My.MySettings.Default.Login_Promedio_servicios
            If (Me.IsLocalFileSystemWebService(Me.Url) = true) Then
                Me.UseDefaultCredentials = true
                Me.useDefaultCredentialsSetExplicitly = false
            Else
                Me.useDefaultCredentialsSetExplicitly = true
            End If
        End Sub
        
        Public Shadows Property Url() As String
            Get
                Return MyBase.Url
            End Get
            Set
                If (((Me.IsLocalFileSystemWebService(MyBase.Url) = true)  _
                            AndAlso (Me.useDefaultCredentialsSetExplicitly = false))  _
                            AndAlso (Me.IsLocalFileSystemWebService(value) = false)) Then
                    MyBase.UseDefaultCredentials = false
                End If
                MyBase.Url = value
            End Set
        End Property
        
        Public Shadows Property UseDefaultCredentials() As Boolean
            Get
                Return MyBase.UseDefaultCredentials
            End Get
            Set
                MyBase.UseDefaultCredentials = value
                Me.useDefaultCredentialsSetExplicitly = true
            End Set
        End Property
        
        '''<remarks/>
        Public Event GetMessageCompleted As GetMessageCompletedEventHandler
        
        '''<remarks/>
        Public Event CalculaPromedioCompleted As CalculaPromedioCompletedEventHandler
        
        '''<remarks/>
        Public Event LoginCompleted As LoginCompletedEventHandler
        
        '''<remarks/>
        Public Event EjecutarLoginCompleted As EjecutarLoginCompletedEventHandler
        
        '''<remarks/>
        <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetMessage", RequestNamespace:="http://tempuri.org/", ResponseNamespace:="http://tempuri.org/", Use:=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)>  _
        Public Function GetMessage() As String
            Dim results() As Object = Me.Invoke("GetMessage", New Object(-1) {})
            Return CType(results(0),String)
        End Function
        
        '''<remarks/>
        Public Overloads Sub GetMessageAsync()
            Me.GetMessageAsync(Nothing)
        End Sub
        
        '''<remarks/>
        Public Overloads Sub GetMessageAsync(ByVal userState As Object)
            If (Me.GetMessageOperationCompleted Is Nothing) Then
                Me.GetMessageOperationCompleted = AddressOf Me.OnGetMessageOperationCompleted
            End If
            Me.InvokeAsync("GetMessage", New Object(-1) {}, Me.GetMessageOperationCompleted, userState)
        End Sub
        
        Private Sub OnGetMessageOperationCompleted(ByVal arg As Object)
            If (Not (Me.GetMessageCompletedEvent) Is Nothing) Then
                Dim invokeArgs As System.Web.Services.Protocols.InvokeCompletedEventArgs = CType(arg,System.Web.Services.Protocols.InvokeCompletedEventArgs)
                RaiseEvent GetMessageCompleted(Me, New GetMessageCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState))
            End If
        End Sub
        
        '''<remarks/>
        <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/CalculaPromedio", RequestNamespace:="http://tempuri.org/", ResponseNamespace:="http://tempuri.org/", Use:=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)>  _
        Public Function CalculaPromedio(ByVal Numero1 As Double, ByVal Numero2 As Double) As Double
            Dim results() As Object = Me.Invoke("CalculaPromedio", New Object() {Numero1, Numero2})
            Return CType(results(0),Double)
        End Function
        
        '''<remarks/>
        Public Overloads Sub CalculaPromedioAsync(ByVal Numero1 As Double, ByVal Numero2 As Double)
            Me.CalculaPromedioAsync(Numero1, Numero2, Nothing)
        End Sub
        
        '''<remarks/>
        Public Overloads Sub CalculaPromedioAsync(ByVal Numero1 As Double, ByVal Numero2 As Double, ByVal userState As Object)
            If (Me.CalculaPromedioOperationCompleted Is Nothing) Then
                Me.CalculaPromedioOperationCompleted = AddressOf Me.OnCalculaPromedioOperationCompleted
            End If
            Me.InvokeAsync("CalculaPromedio", New Object() {Numero1, Numero2}, Me.CalculaPromedioOperationCompleted, userState)
        End Sub
        
        Private Sub OnCalculaPromedioOperationCompleted(ByVal arg As Object)
            If (Not (Me.CalculaPromedioCompletedEvent) Is Nothing) Then
                Dim invokeArgs As System.Web.Services.Protocols.InvokeCompletedEventArgs = CType(arg,System.Web.Services.Protocols.InvokeCompletedEventArgs)
                RaiseEvent CalculaPromedioCompleted(Me, New CalculaPromedioCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState))
            End If
        End Sub
        
        '''<remarks/>
        <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/Login", RequestNamespace:="http://tempuri.org/", ResponseNamespace:="http://tempuri.org/", Use:=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)>  _
        Public Function Login(ByVal user As String, ByVal password As String) As String
            Dim results() As Object = Me.Invoke("Login", New Object() {user, password})
            Return CType(results(0),String)
        End Function
        
        '''<remarks/>
        Public Overloads Sub LoginAsync(ByVal user As String, ByVal password As String)
            Me.LoginAsync(user, password, Nothing)
        End Sub
        
        '''<remarks/>
        Public Overloads Sub LoginAsync(ByVal user As String, ByVal password As String, ByVal userState As Object)
            If (Me.LoginOperationCompleted Is Nothing) Then
                Me.LoginOperationCompleted = AddressOf Me.OnLoginOperationCompleted
            End If
            Me.InvokeAsync("Login", New Object() {user, password}, Me.LoginOperationCompleted, userState)
        End Sub
        
        Private Sub OnLoginOperationCompleted(ByVal arg As Object)
            If (Not (Me.LoginCompletedEvent) Is Nothing) Then
                Dim invokeArgs As System.Web.Services.Protocols.InvokeCompletedEventArgs = CType(arg,System.Web.Services.Protocols.InvokeCompletedEventArgs)
                RaiseEvent LoginCompleted(Me, New LoginCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState))
            End If
        End Sub
        
        '''<remarks/>
        <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/EjecutarLogin", RequestNamespace:="http://tempuri.org/", ResponseNamespace:="http://tempuri.org/", Use:=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)>  _
        Public Function EjecutarLogin(ByVal usuario As String, ByVal clave As String) As Integer
            Dim results() As Object = Me.Invoke("EjecutarLogin", New Object() {usuario, clave})
            Return CType(results(0),Integer)
        End Function
        
        '''<remarks/>
        Public Overloads Sub EjecutarLoginAsync(ByVal usuario As String, ByVal clave As String)
            Me.EjecutarLoginAsync(usuario, clave, Nothing)
        End Sub
        
        '''<remarks/>
        Public Overloads Sub EjecutarLoginAsync(ByVal usuario As String, ByVal clave As String, ByVal userState As Object)
            If (Me.EjecutarLoginOperationCompleted Is Nothing) Then
                Me.EjecutarLoginOperationCompleted = AddressOf Me.OnEjecutarLoginOperationCompleted
            End If
            Me.InvokeAsync("EjecutarLogin", New Object() {usuario, clave}, Me.EjecutarLoginOperationCompleted, userState)
        End Sub
        
        Private Sub OnEjecutarLoginOperationCompleted(ByVal arg As Object)
            If (Not (Me.EjecutarLoginCompletedEvent) Is Nothing) Then
                Dim invokeArgs As System.Web.Services.Protocols.InvokeCompletedEventArgs = CType(arg,System.Web.Services.Protocols.InvokeCompletedEventArgs)
                RaiseEvent EjecutarLoginCompleted(Me, New EjecutarLoginCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState))
            End If
        End Sub
        
        '''<remarks/>
        Public Shadows Sub CancelAsync(ByVal userState As Object)
            MyBase.CancelAsync(userState)
        End Sub
        
        Private Function IsLocalFileSystemWebService(ByVal url As String) As Boolean
            If ((url Is Nothing)  _
                        OrElse (url Is String.Empty)) Then
                Return false
            End If
            Dim wsUri As System.Uri = New System.Uri(url)
            If ((wsUri.Port >= 1024)  _
                        AndAlso (String.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) = 0)) Then
                Return true
            End If
            Return false
        End Function
    End Class
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")>  _
    Public Delegate Sub GetMessageCompletedEventHandler(ByVal sender As Object, ByVal e As GetMessageCompletedEventArgs)
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433"),  _
     System.Diagnostics.DebuggerStepThroughAttribute(),  _
     System.ComponentModel.DesignerCategoryAttribute("code")>  _
    Partial Public Class GetMessageCompletedEventArgs
        Inherits System.ComponentModel.AsyncCompletedEventArgs
        
        Private results() As Object
        
        Friend Sub New(ByVal results() As Object, ByVal exception As System.Exception, ByVal cancelled As Boolean, ByVal userState As Object)
            MyBase.New(exception, cancelled, userState)
            Me.results = results
        End Sub
        
        '''<remarks/>
        Public ReadOnly Property Result() As String
            Get
                Me.RaiseExceptionIfNecessary
                Return CType(Me.results(0),String)
            End Get
        End Property
    End Class
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")>  _
    Public Delegate Sub CalculaPromedioCompletedEventHandler(ByVal sender As Object, ByVal e As CalculaPromedioCompletedEventArgs)
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433"),  _
     System.Diagnostics.DebuggerStepThroughAttribute(),  _
     System.ComponentModel.DesignerCategoryAttribute("code")>  _
    Partial Public Class CalculaPromedioCompletedEventArgs
        Inherits System.ComponentModel.AsyncCompletedEventArgs
        
        Private results() As Object
        
        Friend Sub New(ByVal results() As Object, ByVal exception As System.Exception, ByVal cancelled As Boolean, ByVal userState As Object)
            MyBase.New(exception, cancelled, userState)
            Me.results = results
        End Sub
        
        '''<remarks/>
        Public ReadOnly Property Result() As Double
            Get
                Me.RaiseExceptionIfNecessary
                Return CType(Me.results(0),Double)
            End Get
        End Property
    End Class
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")>  _
    Public Delegate Sub LoginCompletedEventHandler(ByVal sender As Object, ByVal e As LoginCompletedEventArgs)
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433"),  _
     System.Diagnostics.DebuggerStepThroughAttribute(),  _
     System.ComponentModel.DesignerCategoryAttribute("code")>  _
    Partial Public Class LoginCompletedEventArgs
        Inherits System.ComponentModel.AsyncCompletedEventArgs
        
        Private results() As Object
        
        Friend Sub New(ByVal results() As Object, ByVal exception As System.Exception, ByVal cancelled As Boolean, ByVal userState As Object)
            MyBase.New(exception, cancelled, userState)
            Me.results = results
        End Sub
        
        '''<remarks/>
        Public ReadOnly Property Result() As String
            Get
                Me.RaiseExceptionIfNecessary
                Return CType(Me.results(0),String)
            End Get
        End Property
    End Class
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433")>  _
    Public Delegate Sub EjecutarLoginCompletedEventHandler(ByVal sender As Object, ByVal e As EjecutarLoginCompletedEventArgs)
    
    '''<remarks/>
    <System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "2.0.50727.1433"),  _
     System.Diagnostics.DebuggerStepThroughAttribute(),  _
     System.ComponentModel.DesignerCategoryAttribute("code")>  _
    Partial Public Class EjecutarLoginCompletedEventArgs
        Inherits System.ComponentModel.AsyncCompletedEventArgs
        
        Private results() As Object
        
        Friend Sub New(ByVal results() As Object, ByVal exception As System.Exception, ByVal cancelled As Boolean, ByVal userState As Object)
            MyBase.New(exception, cancelled, userState)
            Me.results = results
        End Sub
        
        '''<remarks/>
        Public ReadOnly Property Result() As Integer
            Get
                Me.RaiseExceptionIfNecessary
                Return CType(Me.results(0),Integer)
            End Get
        End Property
    End Class
End Namespace