package Tema5.Examen2021;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PeliculasDeUnTema {
    private String tema;
    private LinkedList<Pelicula> listaPeliculasDeUnTema;

    public PeliculasDeUnTema(String tema) {
        this.tema = tema;
        listaPeliculasDeUnTema = new LinkedList<>();
    }

    public String getTema() {
        return getTema();
    }

    public void addPelicula(Pelicula pelicula) throws NetPleaseException {
        if (pelicula == null || listaPeliculasDeUnTema.contains(pelicula)) {
            throw new NetPleaseException("Error, la pelicula no es valida. Asegurese de que no se haya introducido ya");
        }
        if (LocalDate.now().getYear() < pelicula.getAnnoEstreno()) {
            throw new NetPleaseException("El año de estreno es invalido");
        }

        listaPeliculasDeUnTema.add(pelicula);
    }

    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {
        /*List<Pelicula> peliculasConAnno = listaPeliculasDeUnTema.stream()
                .filter(a -> a.getAnnoEstreno() == anno).toList();

        if (peliculasConAnno.isEmpty()) throw new NetPleaseException("No hay peliculas con ese año");

        peliculasConAnno.forEach(a -> listaPeliculasDeUnTema.remove(a));
        */

        /*Iterator<Pelicula> it = listaPeliculasDeUnTema.iterator();
        while (it.hasNext()) {
            if (it.next().getAnnoEstreno() == anno) it.remove();
        }*/
        if (!listaPeliculasDeUnTema.removeIf(pelicula -> pelicula.getAnnoEstreno() == anno)) {
            throw new NetPleaseException("No hay peliculas con ese año");
        }

        /*listaPeliculasDeUnTema.stream().filter(a -> a.getAnnoEstreno() == anno)
                .forEach(a -> listaPeliculasDeUnTema.remove(a));
        */
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {
//        Optional<Pelicula> optionalPelicula = listaPeliculasDeUnTema.stream()
//                .filter(a -> a.getTitulo().equals(tituloPelicula)).findFirst();
//
//        if (optionalPelicula.isEmpty()) throw new NetPleaseException("No hay peliculas con ese titulo");
//
//        Pelicula peliculaAOpinar = optionalPelicula.get();
//        peliculaAOpinar.annadirOpinion(opinion);

        Pelicula p = buscarPeliculaPorTitulo(tituloPelicula);

        if (p == null){
            throw new NetPleaseException("La película no existe");
        }

        p.annadirOpinion(opinion);
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {

//        listaPeliculasDeUnTema.sort((a, b) -> Double.compare(b.mediaDeOpiniones(), a.mediaDeOpiniones()));

//        return listaPeliculasDeUnTema;

        return listaPeliculasDeUnTema.stream()
                .sorted((a, b) -> Double.compare(b.mediaDeOpiniones(), a.mediaDeOpiniones())).toList();
    }


    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {
        return listaPeliculasDeUnTema.stream().filter(p -> p.intervieneActor(actor)).toList();
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) {
        for (Pelicula p : listaPeliculasDeUnTema){
            if (titulo.equals(p.getTitulo())){
                return p;
            }
        }

        return null;
        //return listaPeliculasDeUnTema.stream().filter(a -> a.getTitulo().equals(titulo)).findFirst().orElse(null);
    }

    public boolean borrar(String titulo){
        return listaPeliculasDeUnTema.removeIf(p -> p.getTitulo().equals(titulo));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tema == null) ? 0 : tema.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
        if (tema == null) {
            if (other.tema != null)
                return false;
        } else if (!tema.equals(other.tema))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema " + tema + "\n");
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            sb.append(pelicula + "\n");
        }
        return sb.toString();
    }
}
