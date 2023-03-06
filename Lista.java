package EjercicioDiapositivas;

import java.util.Arrays;

    public class Lista implements Pila, Cola {
        Integer[] tabla;

        public Lista() {
            tabla = new Integer[0];
        }

        void insertarPrincipio(Integer nuevo) {
            tabla = Arrays.copyOf(tabla, tabla.length + 1);
            System.arraycopy(tabla, 0, tabla, 1, tabla.length - 1);
            tabla[0] = nuevo;
        }

        void insertarFinal(Integer nuevo) {
            tabla = Arrays.copyOf(tabla, tabla.length + 1);
            tabla[tabla.length - 1] = nuevo;
        }

        void insertarFinal(Lista otraLista) {
            int tamIni = tabla.length;
            tabla = Arrays.copyOf(tabla, tabla.length + otraLista.tabla.length);
            System.arraycopy(otraLista.tabla, 0, tabla, tamIni, otraLista.tabla.length);
        }

        void insertar(int posicion, Integer nuevo) {
            tabla = Arrays.copyOf(tabla, tabla.length + 1);
            System.arraycopy(tabla, posicion, tabla, posicion + 1,
                    tabla.length - posicion - 1);
            tabla[posicion] = nuevo;
        }

        Integer eliminar(int indice) {
            Integer eliminado = null;
            if (indice >= 0 && indice < tabla.length) {
                eliminado = tabla[indice];
                for (int i = indice + 1; i < tabla.length; i++) {
                    tabla[i - 1] = tabla[i];
                }
                tabla = Arrays.copyOf(tabla, tabla.length - 1);
            }
            return eliminado;
        }

        Integer get(int indice) {
            Integer resultado = null;
            if (indice >= 0 && indice < tabla.length) {
                resultado = tabla[indice];
            }
            return resultado;
        }

        int buscar(Integer claveBusqueda) {
            int indice = -1;
            for (int i = 0; i < tabla.length && indice == -1; i++) {
                if (tabla[i].equals(claveBusqueda)) {
                    indice = i;
                } else {
                }
            }
            return indice;
        }

        public int numeroElementos() {
            return tabla.length;
        }

        public void mostrar() {
            System.out.println("Lista: " + Arrays.toString(tabla));
        }


        public void encolar(int nuevo){
            insertarFinal(nuevo);
        }

        public void desencolar(){
            eliminar(0);
        }
        public void apilar(int nuevo){
            insertarPrincipio(nuevo);
        }
        public void desapilar() {
            eliminar(0);
        }
        public void encolarSeguido(){
            Scanner sc = new Scanner(System.in);
            int  num;
            do {
                System.out.println("Introduce un numero");
                num = sc.nextInt();
                if (num > 0) {
                    encolar(num);
                }
            } while (num > 0);
            }
        public void vaciarCola(){
            while (numeroElementos() > 0) {
                desencolar();
            }
        }
    }

