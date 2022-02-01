
package proyectoparqueo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Clase {
    
    static String parqueoEspacios[];//Array para definir el tamaño del parqueo.
    static String usuarios[];//Array para almacenar usuarios del sistema.
    static String contraseñas[];//Array para almacenar contraseñas de los usuarios.
    static String parqueoEstado[];//Array para definir el estado de los vehiculos Libre/Ocupado
    static String parqueoTipos[];//Array donde se alamacena el tipo de vehiculo
    static String parqueoPlacas[]; //Array donde se almacena las placas de los vehiculos
    static int parqueoHoras[];//Array donde almaceno las horas de entrada
    static int parqueoMinutos[];//Array donde almaceno los minutos de entrada
    static String mostrarDatosUsuarios="";//Acumula los usuarios registrados para mostrarlos en pantalla
    static String mostrarDatosVehiculos="";//Acumula los datos de los vehiculos ingresados para mostrarlos en pantalla
    static String mostrarEspacios="";//Acumula los espacios del parqueo para mostrarlos en pantalla
    static String mostrarSalidaVehiculos="";//Acumula el registro de todas los procesos de ingreso, retiro y cobro del parqueo
    static int conCarros=0;//Contador que lleva registro de todos los carros ingresados
    static int conMotos=0;//Contador que lleva registro de todas las motos ingresadsas
    static int conVehiculos=0;//Contador que lleva registro de todos los vehiculos en general
    static int conTotalCarros=0;//Acumulador que lleva el registro del dinero generado por carros
    static int conTotalMotos=0;//Acumulador que lleva el registro del dinero generado por motos
    static int conTotalVehiculos=0;//Acumulador que lleva el registro del dinero generado en total
  


    public static void main(String[] args){//Metodo main.
        
        login();//Invocar el metodo login.
    }
   
    public static void login(){ //Metodo donde se validan los usuarios.
        ImageIcon entrar=new ImageIcon("src/iconos/ENTRAR.png");
        ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
        
        String usuario,contraseña;//Variables.
        
        usuario=(String)JOptionPane.showInputDialog(null,"Digite su nombre de usuario(# de cedula)","LOGIN",0,entrar,null,null);
        contraseña=(String)JOptionPane.showInputDialog(null,"Digite su contraseña","LOGIN",0,entrar,null,null);
        
        for(int i=0;i<3;i++){
                
            if((usuario.equals("admin")&& contraseña.equals("123"))){//Valida si usuarios y contraseñas son correctos e ingresa al menu.
                
               menu();//Invocación metodo menu.
                
                }else if(usuario.equals("")|| contraseña.equals("")){//Valida si los espacios de usuario o contraseña fueron dejados en blanco para enviar mensaje de error.
                    
                    JOptionPane.showMessageDialog(null,"Usuario/Contraseña incorrecto","ADVERTENCIA",0,salir); //Mensaje de error. 
                    login();//Invoca metodo login para digitar nuevamente el usuario y la contraseña
                    
                    }else if((!usuario.equals("admin")|| !contraseña.equals("123"))){//Valida si usuarios y contraseñas son diferentes para enviar mensaje de error.
                        
                        JOptionPane.showMessageDialog(null,"Usuario/Contraseña incorrecto","ADVERTENCIA",0,salir);//Mensaje de error.
                        login();//Invoca metodo login para digitar nuevamente el usuario y la contraseña
                    }
        }
    }
    
    public static void login2(){
        ImageIcon entrar=new ImageIcon("src/iconos/ENTRAR.png");
        ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
        
        String usuario,contraseña;//Variables.
        
        usuario=(String)JOptionPane.showInputDialog(null,"Digite su nombre de usuario(# de cedula)","LOGIN",0,entrar,null,null);
        contraseña=(String)JOptionPane.showInputDialog(null,"Digite su contraseña","LOGIN",0,entrar,null,null);
        
        for(int i=0;i<usuarios.length;i++){
                
            if((usuario.equals("admin")&& contraseña.equals("123")) || (usuario.equals(usuarios[i])&& contraseña.equals(contraseñas[i]))){//Valida si usuarios y contraseñas son correctos e ingresa al menu.
                
               menu();//Invocación metodo menu.
                
                }else if(usuario.equals("")|| contraseña.equals("")){//Valida si los espacios de usuario o contraseña fueron dejados en blanco para enviar mensaje de error.
                    
                    JOptionPane.showMessageDialog(null,"Usuario/Contraseña incorrecto","ADVERTENCIA",0,salir); //Mensaje de error. 
                    login();//Invoca metodo login para digitar nuevamente el usuario y la contraseña
                    
                    }else if((!usuario.equals("admin")|| !contraseña.equals("123")) || (usuario.equals(usuarios[i])|| contraseña.equals(contraseñas[i]))){//Valida si usuarios y contraseñas son diferentes para enviar mensaje de error.
                        
                        JOptionPane.showMessageDialog(null,"Usuario/Contraseña incorrecto","ADVERTENCIA",0,salir);//Mensaje de error.
                        login();//Invoca metodo login para digitar nuevamente el usuario y la contraseña
                    }
        }
    }
    
    public static void menu(){//Metodo menu.
        ImageIcon menu=new ImageIcon("src/iconos/MENU.png");
        ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
        String menuFormato,opcion;//Variables
        
         menuFormato=("*********************************************\n"+   
            "*                        Menu                                     *\n"+
            "*********************************************\n"+
            "  1.Administración de Usuarios              \n"+
            "  2.Tamaño del parqueo                      \n"+
            "  3.Ver espacios disponibles                \n"+
            "  4.Ingreso de vehículos                    \n"+
            "  5.Salida de vehículos                     \n"+
            "  6.Contabilidad                            \n"+        
            "  7.Salir                                   \n"+
            "*********************************************\n");
       
        
        opcion=(String)JOptionPane.showInputDialog(null,menuFormato,"MENU PARQUEO",0,menu,null,null);
        
        switch(opcion){//Switch que valida la opción digitada.
            case "1":
                administrarUsuarios();//Invoca metodo ingresarUsuarios 
            break;
            
            case "2":
                tamañoParqueo();//Invoca metodo tamañoParqueo
            break;
            
            case "3":
                estadoEspacios();//Invoca metodo estadoEspacios
            break;
            
            case "4":
                ingresarVehiculos();//Invoca metodo ingresarVehiculos
            break;
            
            case "5":
                salidaVehiculos();//Invoca metodo salidaVehiculos
            break;
            
            case "6":
                contabilidad();//Invoca metodo contabilidad
            break;
            
            case "7":
                JOptionPane.showMessageDialog(null,"Gracias por usar mi programa","SALIR",0,menu);//Muestra mensaje de salida del sistema.
                System.exit(0);//Finaliza ejecución del programa
            break;
            
            default:
                JOptionPane.showMessageDialog(null,"Opción erronea","ADVERTENCIA",0,salir);//Muestra mensaje de error si se escoge una opción inexistente en el menu.
                menu();//Me devuelve nuevamente al metodo menu

        }
        
          
    }
    
    public static void administrarUsuarios(){//Metodo para ingresar los usuarios del sistema.
       String opcion;
       ImageIcon usuario=new ImageIcon("src/iconos/USUARIO.png");
       ImageIcon llenar=new ImageIcon("src/iconos/LLENAR.png");
       ImageIcon matriz=new ImageIcon("src/iconos/MATRIZ.png");
       ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
       
      
       opcion=(String)JOptionPane.showInputDialog(null,"1.Ingresar Usuarios\n2.Ver Usuarios\n3.Cerrar Sesión\n4.Volver al Menu","ADMINISTRAR USUARIOS",0,usuario,null,null);
       switch(opcion){
           case "1":
               int cantidad;
               cantidad=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Digite la cantidad de usaurios del sistema","REGISTRAR USUARIO",0,llenar,null,null));
               
               if(cantidad==0){
                   JOptionPane.showMessageDialog(null,"La cantidad de usuarios no pueden ser cero","ADVERTENCIA",0,salir);
                   administrarUsuarios();
               }else{
                   usuarios = new String[cantidad];
                   contraseñas = new String[cantidad];
                   
                   for(int i=0;i<cantidad;i++){
                   
                   usuarios[i]=(String)JOptionPane.showInputDialog(null,"Digite el nombre de usuario(Cedula)","REGISTRAR USUARIO",0,llenar,null,null);
                   contraseñas[i]=(String)JOptionPane.showInputDialog(null,"Digite la contraseña","REGISTRAR CONTRASEÑA",0,llenar,null,null);
                   mostrarDatosUsuarios+="Usuario: "+usuarios[i]+"  Contraseña: "+contraseñas[i]+"\n";
               }
               administrarUsuarios();
              }
           break;
                
           case "2":
               
              if(usuarios==null){
                  JOptionPane.showMessageDialog(null,"Ingrese los usuarios primero!","ADVERTENCIA",0,salir);
                  administrarUsuarios();
               }else{
                   JOptionPane.showMessageDialog(null,mostrarDatosUsuarios,"DATOS USUARIOS",0,matriz);
                   administrarUsuarios();
              }
                
            break;
           
           case "3":
               if(usuarios==null){
                  JOptionPane.showMessageDialog(null,"Ingrese los usuarios primero!","ADVERTENCIA",0,salir);
                  administrarUsuarios();
               }else{
                   login2();
              }
           break;
           
           case "4":
               menu();
           break;
           
           default:JOptionPane.showMessageDialog(null,"Opción erronea!","ADVERTENCIA",0,salir);//Muestra mensaje de error si se escoge una opción inexistente en el menu.
           administrarUsuarios();
       }
   }
    
    public static void tamañoParqueo(){//Metodo para definir el tamaño arreglo con los espacios del parqueo.
       
       int espacios;//Variable
       ImageIcon llenar=new ImageIcon("src/iconos/LLENAR.png");
       ImageIcon check=new ImageIcon("src/iconos/CHECK.png");  
       
       
       espacios=Integer.parseInt((String) JOptionPane.showInputDialog(null,"Digite la cantidad de espacios del parqueo","DEFINIR ESPACIOS PARQUEO",0,llenar,null,null));//Solicito al usuario la cantidad de espacios del parqueo.
       parqueoEspacios = new String[espacios];//Inicializo el arreglo segun la cantidad digitada previamente.
       parqueoEstado = new String[espacios];
       parqueoTipos = new String[espacios];
       parqueoPlacas = new String[espacios];
       parqueoHoras = new int[espacios];
       parqueoMinutos = new int[espacios];
                    
      for(int i=0;i<parqueoEspacios.length;i++){
          parqueoEstado[i]="Libre";
          parqueoEspacios[i]="Espacio "+i+": "+" Estado: "+parqueoEstado[i]+"\n\n";
          
        }
       JOptionPane.showMessageDialog(null,"Espacios creados correctamente","AVISO",0,check);
       menu();
    }
   
    public static void estadoEspacios(){//Metodo que me muestra el arreglo con los espacios del parqueo.
        ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
        ImageIcon carro=new ImageIcon("src/iconos/CARRO.png");
        
       if(parqueoEspacios==null){
           
           JOptionPane.showMessageDialog(null,"Debe ingresar el tamaño del parqueo!","ADVERTENCIA",0,salir); 
           menu();
           
       }else{
           
           mostrarEspacios="";
           
           for(int i=0;i<parqueoEspacios.length;i++){
               
                mostrarEspacios+="Espacio "+i+": "+" Estado: "+parqueoEstado[i]+"\n\n";
                
           }
           
           JOptionPane.showMessageDialog(null,parqueoEspacios,"ESPACIOS DISPONIBLES",0,carro);  
           
           menu();
       }
       
   }
   
    public static void ingresarVehiculos(){//Metodo que me permite almacenar los vehiculos en el arreglo del parqueo.
       ImageIcon llenar=new ImageIcon("src/iconos/LLENAR.png");
       ImageIcon check=new ImageIcon("src/iconos/CHECK.png"); 
       ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
       
       int posicion;//Variable para buscar posiciones en el arreglo. 
       
       
       if(parqueoEspacios==null){
           
           JOptionPane.showMessageDialog(null,"Debe ingresar el tamaño del parqueo!","ADVERTENCIA",0,salir); 
           menu();
           
       }else{
       
           posicion=Integer.parseInt((String)JOptionPane.showInputDialog(null,"En que posición desea guardar el vehiculo?\n\n"+mostrarEspacios,"INGRESO DE VEHICULOS",0,llenar,null,null));
       
            if(posicion>parqueoEspacios.length){

                JOptionPane.showMessageDialog(null,"Posición digitada no existe!","ADVERTENCIA",0,salir);
                ingresarVehiculos();

            }else{
           
          if(parqueoEstado[posicion].equals("Libre")){
           
           for(int i=0;i<parqueoEspacios.length;i++){
               
               if(parqueoEspacios[posicion].equals(parqueoEspacios[i])){
                   
                    parqueoPlacas[i]=(String)JOptionPane.showInputDialog(null,"Ingrese la placa del vehiculo","INGRESO DE PLACA",0,llenar,null,null);
                    
                    parqueoTipos[i]=(String)JOptionPane.showInputDialog(null,"Ingrese el tipo de vehiculo(Carro/Moto)","TIPO DE VEHICULO",0,llenar,null,null);
                    
                    if( parqueoTipos[i].equals("Carro")){
                        conCarros++;
                    }else{
                        conMotos++;
                    }
                    
                    parqueoHoras[i]=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Ingrese hora de entrada","HORA DE ENTRADA",0,llenar,null,null));
                    
                    parqueoMinutos[i]=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Ingrese minuto de entrada","HORA DE ENTRADA",0,llenar,null,null));
                    
                    parqueoEspacios[i]=parqueoEstado[i]="Ocupado";
                    
                    parqueoEspacios[i]="Espacio "+i+": "+" Estado: "+parqueoEstado[i]+"\n\n";
                    
                    JOptionPane.showMessageDialog(null,"Vehiculo guardado","AVISO",0,check);
                    conVehiculos++;
                    menu(); 
                }
            }
           
        }else{
           JOptionPane.showMessageDialog(null,"Espacio ya se encuentra ocupado!","ADVERTENCIA",0,salir); 
        }
           
      }
    }
       
    }
    
    public static void salidaVehiculos(){//Metodo que me permite borrar un vehiculo del arreglo del parqueo.
        
       ImageIcon llenar=new ImageIcon("src/iconos/LLENAR.png");
       ImageIcon check=new ImageIcon("src/iconos/CHECK.png"); 
       ImageIcon salir=new ImageIcon("src/iconos/SALIR.png");
       ImageIcon matriz=new ImageIcon("src/iconos/MATRIZ.png");
       ImageIcon carro=new ImageIcon("src/iconos/CARRO.png");
       String acumulador="";
       String posicion;//Variable para buscar posiciones en el arreglo. 
       String total="";//acumulador para mostrar las horas
       int horaSalida,minutoSalida,totalh=0,totalm=0,totaltiempo;//variables para almacenar las horas y minutos de salida y hacer los calculos
       
       
       if(parqueoEspacios==null){
           
           JOptionPane.showMessageDialog(null,"Debe ingresar el tamaño del parqueo!","ADVERTENCIA",0,salir); 
           menu();
           
        }else{
           
           posicion=(String)JOptionPane.showInputDialog(null,"Cual vehiculo desea retirar(Digite la placa)?\n\n","RETIRO DE VEHICULOS",0,matriz,null,null);//Solicito al usuario la placa del vehiculo a retirar
       
       
           for(int i=0;i<parqueoPlacas.length;i++){//Recorro el arreglo para buscar la placa solicitada
               
               if(posicion.equals(parqueoPlacas[i])){
                   
                   if(parqueoHoras[i]<10){
                       acumulador+="0"+parqueoHoras[i]+":"+parqueoMinutos[i];
                   }else if(parqueoMinutos[i]>=0 || parqueoMinutos[i]<10){
                       acumulador+=parqueoHoras[i]+":"+"0"+parqueoMinutos[i];
                   }else{
                       acumulador+=parqueoHoras[i]+":"+parqueoMinutos[i];
                   }
                   
                   mostrarDatosVehiculos+="Placa: "+parqueoPlacas[i]+"\nTipo vehiculo: "+parqueoTipos[i]+"\nHora entrada: "+acumulador+"\n";
                   JOptionPane.showMessageDialog(null,mostrarDatosVehiculos,"INFORMACIÓN",0,matriz);
                   
                    horaSalida=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Ingrese hora de Salida","HORA DE SALIDA",0,llenar,null,null));//Solicito la hora de salida
                    minutoSalida=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Ingrese minuto de Salida","HORA DE SALIDA",0,llenar,null,null));//Solicito el minuto de salida
                    
                    if(horaSalida>parqueoHoras[i]){//Realizo los calculos de cuantas horas estuvo el carro en el parqueo
                        totalh=horaSalida-parqueoHoras[i];
                        totalm=minutoSalida-parqueoMinutos[i];
                        total+=totalh+" : "+totalm;
                    }
                    
                    if(parqueoTipos[i].equals("Carro")){//Realizo el calculo de cuanto es el total a pagar dependiendo del tipo de vehiculo
                        
                        if(totalm<=15){//Si los minutos son igual o menor a 15 no se le cobra la hora 
                           totaltiempo=totalh*800; 
                        }else{//Si son mas de 15 minutos se le cobra la hora
                            totaltiempo=(totalh+1)*800;
                        }
                        conTotalCarros+=totaltiempo;
                    }else{
                        if(totalm<=15){
                           totaltiempo=totalh*600; 
                        }else{
                            totaltiempo=(totalh+1)*600;
                        }
                        
                        conTotalMotos+=totaltiempo;
                    }
                    
                    parqueoPlacas[i]="";
                    
                    parqueoTipos[i]="";
                    
                    parqueoHoras[i]=0;
                    
                    parqueoMinutos[i]=0;
                    
                    parqueoEspacios[i]=parqueoEstado[i]="Libre";
                    
                    parqueoEspacios[i]="Espacio "+i+": "+" Estado: "+parqueoEstado[i]+"\n\n";
                    
                    JOptionPane.showMessageDialog(null,"Vehiculo retirado","AVISO",0,check);//Mensaje de confirmacion del retiro del vehiculo
                    
                    JOptionPane.showMessageDialog(null,mostrarDatosVehiculos+"\n\nEl vehiculo estuvo: "+total+".\nSu total a pagar es: "+totaltiempo,"AVISO",0,carro);//Muestro al usuario cuantas horas estuvo el vehiculo y el total a pagar
                    
                    menu(); //Vuelvo al metodo menu 
                }
            }
        }
    }
      
    
    public static void contabilidad(){
        ImageIcon matriz=new ImageIcon("src/iconos/MATRIZ.png");
        
        conTotalVehiculos=conTotalCarros+conTotalMotos;
        
        mostrarSalidaVehiculos+="Contabilidad Parqueo\n\n\n"+"Cantidad de vehiculos procesados: "+conVehiculos+"\n"+"Carros: "+conCarros+"\n"+"Motos: "+conMotos+"\n\n"+
                                            "Total dinero generado por todos los vehicuos: "+ conTotalVehiculos+"\n"+"Total generado por Carros: "+conTotalCarros+"\n"+"Total generado por Motos: "+conTotalMotos+"\n";
        
        JOptionPane.showMessageDialog(null,mostrarSalidaVehiculos,"CONTABILIDAD",0,matriz);
        menu();
    }
}
