reglaGramatical = r;
raiz.elemento = ficha;

//        //LOS VERTICES IZQUIERDOS VAN A SER LOS VERTICES FUERTES.
//        if (!Gramatica.sePuedeDerivar(l,r)){
//            throw new IllegalArgumentException("Hay un error. En la derivacion.");
//            return;
//        }
//NO SE ESTAN ELIMINANDO LOS ARBOLES QUE SOBRAN NI LOS USADOS.

//Para las gramaticas de n componentes.
Lista<ArbolSintactico<T>> acotada;

Vertice<T> leftVertice;
Vertice<T> rightVertice;

ArbolSintactico<T> left;
ArbolSintactico<T> right;
//Para las gramaticas de 1 componente.
Vertice<T> verticeContenedor;
ArbolSintactico<T> unico;
switch(r){
case _1_S_E:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;




break;
case _2_E_E_T:

acotada = l.getUltimos(3);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;



//                if(f.getFicha().getSimbolo() == Simbolo.E)
//                    siSePuede = true;
break;
case _3_E_E__T:

acotada = l.getUltimos(3);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;

//                if(f.getFicha().getSimbolo() == Simbolo.E)
//                    siSePuede = true;
break;
case _4_E_T:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;

//                if(f.getFicha().getSimbolo() == Simbolo.E)
//                    siSePuede = true;
break;
case _5_T_T_F:

acotada = l.getUltimos(3);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;

//                if(f.getFicha().getSimbolo() == Simbolo.T)
//                    siSePuede = true;
break;
case _6_T_T__F:

acotada = l.getUltimos(3);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;

//                if(f.getFicha().getSimbolo() == Simbolo.T)
//                    siSePuede = true;
break;
case _7_T_F:


unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;
//                if(f.getFicha().getSimbolo() == Simbolo.T)
//                    siSePuede = true;
break;
case _8_F_F_M:

acotada = l.getUltimos(3);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;

//                if(f.getFicha().getSimbolo() == Simbolo.F)
//                    siSePuede = true;
break;
case _9_F_M:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;

//                if(f.getFicha().getSimbolo() == Simbolo.F)
//                    siSePuede = true;
break;
case _10_M_Y_E_:

acotada = l.getUltimos(4);

left = acotada.getPrimero();

acotada = l.getUltimos(2);
right = acotada.getPrimero();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;

//                if(f.getFicha().getSimbolo() == Simbolo.M)
//                    siSePuede = true;
break;
case _11_M__E_:
//                acotada = l.getUltimos(4);

//                left = acotada.getPrimero();

acotada = l.getUltimos(2);
left = acotada.getPrimero();

leftVertice =  new Vertice<T>(left.getFicha());
//                rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
//                rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
//                raiz.izquierdo = rightVertice;


//                if(f.getFicha().getSimbolo() == Simbolo.M)
//                    siSePuede = true;
break;
case _12_M__E:


acotada = l.getUltimos(2);

left = acotada.getPrimero();
right = acotada.getUltimo();

leftVertice =  new Vertice<T>(left.getFicha());
rightVertice =  new Vertice<T>(right.getFicha());
leftVertice.padre = raiz;
rightVertice.padre = raiz;

raiz.izquierdo = leftVertice;
raiz.izquierdo = rightVertice;


//                if(f.getFicha().getSimbolo() == Simbolo.M)
//                    siSePuede = true;
break;
case _13_M_Q:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;
//                if(f.getFicha().getSimbolo() == Simbolo.M)
//                    siSePuede = true;
break;
case _14_Y_func:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;

//                if(f.getFicha().getSimbolo() == Simbolo.Y)
//                    siSePuede = true;
break;
case _15_Q_num:

unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;

//                if(f.getFicha().getSimbolo() == Simbolo.Q)
//                    siSePuede = true;
break;
case _16_Q_var:


unico = l.getUltimo();
verticeContenedor =  new Vertice<T>(unico.getFicha());
verticeContenedor.padre = raiz;
raiz.izquierdo = verticeContenedor;
//                if(f.getFicha().getSimbolo() == Simbolo.Q)
//                    siSePuede = true;
break;
default:
//                siSePuede = false;

}