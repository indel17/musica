import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        imprimirMenu();

        ArrayList<Album> album = new ArrayList<Album>();
        Album album1 = new Album("Rihanna", "Loud");
        Album album2 = new Album("Emilia", ".mp3");

        album1.addSong("S&M", 4.04);
        album1.addSong("Only Girl (In the World)", 3.55);
        album1.addSong("Man Down", 4.27);
        album1.addSong("Love the Way You Lie", 4.56);
        album1.addSong("Fading", 3.20);
        album1.addSong("Skin", 5.04);
        album1.addSong("Raining Men", 3.45);


        album2.addSong("GTA", 2.31);
        album2.addSong("Ojitos verdes", 2.31);
        album2.addSong("Facts", 2.10);
        album2.addSong("Jagger", 2.35);
        album2.addSong("IConic", 3.01);
        album2.addSong("La_Original", 2.20);
        album2.addSong("Exclusive", 2.01);
        album2.addSong("No_Se_Ve", 3.27);
        album2.addSong("24_Hs", 2.24);
        album2.addSong("Muñecos", 2.46);
        album2.addSong("A_1000_Km", 3.31);
        album2.addSong("Guerrero", 3.59);


        LinkedList<Cancion> MiLista = new LinkedList<Cancion>();
        album1.addToPlayList("Only Girl (In the World)", MiLista);
        album2.addToPlayList("GTA", MiLista);
        album2.addToPlayList("No_Se_Ve", MiLista);


        album2.addToPlayList(1, MiLista);
        album2.addToPlayList(2, MiLista);
        album2.addToPlayList(3, MiLista);

        play2(MiLista);

    }

    public static void Playlist(LinkedList<Cancion> playlist) {

        ListIterator<Cancion> iterator = playlist.listIterator();
        System.out.println("Lista de reproducción: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void play2(LinkedList<Cancion> canciones) {
        boolean haciaAdelante = true;
        ListIterator<Cancion> it = canciones.listIterator();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Se ha puesto en pausa la playlist: MiLista");
                    System.out.println("[ <<  ▷  >> ] [ -------------------------- ] ");
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext()) {
                            it.next();
                        }
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        Cancion siguiente = it.next();
                        System.out.println("Reproduciendo: " + siguiente.getTitulo());
                        System.out.println("[ <<  ||  >> ] [ 0.00 ·------------------------- " + siguiente.duracion + "]");
                    } else {
                        System.out.println("Fin de la lista de reproducción.");
                        haciaAdelante = true;
                    }
                    break;
                case 2:
                    if (haciaAdelante) {
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        Cancion anterior = it.previous();
                        System.out.println("Reproduciendo: " + anterior.getTitulo());
                        System.out.println("[ <<  ||  >> ] [ 0.00 ·------------------------- " + anterior.duracion + "]");
                        it.next(); // Para mantener el iterador en la posición correcta
                    } else {
                        System.out.println("Inicio de la lista de reproducción.");
                        haciaAdelante = true;
                    }
                    break;
                case 3:
                    if (haciaAdelante) {
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                    } else {
                        if (it.hasNext()) {
                            it.next();
                        }
                    }
                    Cancion actual = it.next();
                    System.out.println("Reproduciendo: " + actual.getTitulo());
                    System.out.println("[ <<  ||  >> ] [ 0.00 ·------------------------- " + actual.duracion + "]");
                    break;
                case 4:
                    Playlist(canciones);
                    break;
                case 5:
                    imprimirMenu();
                    break;
                case 6:
                    it.remove();
                    System.out.println("Canción eliminada de la lista de reproducción.");
                    break;
            }

        } while (opcion != 0);
    }


    public static int obtenerOpcion() {


        return 0;
    }


    public static void imprimirMenu() {
        System.out.println(".___________________________________________________.");
        System.out.println("| 0 - Salir de la lista de reproducción             |");
        System.out.println("| 1 - Reproducir siguiente canción de la lista      |");
        System.out.println("| 2 - Reproducir la canción previa de la lista      |");
        System.out.println("| 3 - Repetir la canción actual                     |");
        System.out.println("| 4 - Imprimir la lista de canciones en la playlist |");
        System.out.println("| 5 - Volver a imprimir el menú                     |");
        System.out.println("| 6 - Eliminar canción actual de la playlist        |");
        System.out.println("|___________________________________________________|");


    }
}
