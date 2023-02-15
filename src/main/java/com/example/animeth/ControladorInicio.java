package com.example.animeth;

import com.example.animeth.model.Anime;
import com.example.animeth.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private UsuarioService usuarioService;

    boolean mostarRegistro=false;
    boolean mostrarLogin=true;

    @GetMapping("/")
    public String inicio(Model modelo){

        return "login";
    }

    @RequestMapping(value = "/inicioSesion", method= RequestMethod.POST)
    public String inicioSesion(@ModelAttribute(value="usuario") Usuario usuario, Model model,
                               RedirectAttributes redirAttrs) {
        Usuario usuariodb = usuarioService.obtenerUsuario(usuario.getUser(), usuario.getPassword());
        if (usuariodb != null ){

            model.addAttribute("nombreUsuario",usuariodb.getNombre() +" "+ usuariodb.getApellido());

            model = mostrarListaAnime(model);

            return "index";
        }else {
            redirAttrs.addFlashAttribute("error", "Usuario o Contraseña incorrectos.");

            return "redirect:/";
        }

    }

        public Model mostrarListaAnime(@NotNull Model modelo){
        var animesUno=new Anime();
        animesUno.setImagen("img/3575.jpg");
        animesUno.setNombre("Shingeki no Kyojin Temporada 4");
        animesUno.setDescripcion("La temporada sigue a Gabi Braun y Falco Grice, jóvenes candidatos a guerreros eldianos que buscan heredar el titán blindado de Reiner cuatro años después de la fallida misión de reclamar el titán fundador.\n" +
                "\n" +
                "A medida que el dominio de Marley sobre las naciones rivales comienza a debilitarse debido al desarrollo de armamento anti-titán, planean invadir Paradis para desarrollar su ejército utilizando los recursos de la isla y también recuperar al Titán fundador.");
        animesUno.setEstudio("Estudio:  MAPPA");
        animesUno.setFechaPublicacion("Publicado: Mar 07, 2021");
        animesUno.setActualizacion("Actualizado en: abril 3, 2022");

        var animesDos=new Anime();
        animesDos.setImagen("img/3600.jpeg");
        animesDos.setNombre("Shijou Saikyou no Daimaou, Murabito A ni Tensei suru");
        animesDos.setDescripcion("Como la entidad más poderosa de todos los tiempos, Demon Lord Varvatos piensa que la vida es un gran ronquido. Cuando toma el asunto en sus propias manos y decide reencarnarse, calibra su fuerza mágica para que sea perfectamente promedio.");
        animesDos.setEstudio("Estudio: Blade, Silver Link");
        animesDos.setFechaPublicacion("Publicado: Abr 06, 2022");
        animesDos.setActualizacion("Actualizado en: junio 22, 2022");

        var animes3=new Anime();
        animes3.setImagen("img/3601.jpg");
        animes3.setNombre("El ascenso del Héroe del Escudo Temporada 2");
        animes3.setDescripcion("Segunda temporada del El ascenso del Héroe del Escudo (Tate no Yuusha no Nariagari) en audio español latino.\n" +
                "\n" +
                "Con otra ola ocurriendo en una semana, Naofumi Iwatani y su grupo no tienen tiempo que perder. " +
                "Sin embargo, cuando los murciélagos familiares asaltan Lurolona Village y la cuenta regresiva de Wave se detiene, los Cuatro Héroes Cardinales vuelven a reunirse con la reina, Mirelia Q Melromarc, para una sesión informativa rápida.");
        animes3.setEstudio("Estudio:  DR Movie, Kinema Citrus");
        animes3.setFechaPublicacion("Publicado: Julio 13, 2022");
        animes3.setActualizacion("Actualizado en: noviembre 8, 2022");

        var animes4=new Anime();
        animes4.setImagen("img/3612.jpg");
        animes4.setNombre("Koi wa Sekai Seifuku no Ato de");
        animes4.setDescripcion("A los ojos del público, Fudou Aikawa y Desumi Magahara son enemigos jurados que no tienen nada en común. Fudou, también conocido como ‘Red Gelato’, es el líder del escuadrón de héroes ‘Gelato 5’, cuya misión es lograr la paz mundial.\n" +
                "\n" +
                "Por otro lado, Desumi es la líder de los secuaces de ‘Gecko’, una organización malvada que busca dominar el mundo. Sin embargo, a pesar de estas diferencias, su relación no es exactamente lo que parece. Cuando no están haciendo alarde de estar en la garganta del otro, Desumi y Fudou continúan persiguiendo un amor prohibido.");
        animes4.setEstudio("Estudio:  Project No.9");
        animes4.setFechaPublicacion("Publicado: Abril 7, 2022");
        animes4.setActualizacion("Actualizado en: junio 25, 2022");

        var animes5=new Anime();
        animes5.setImagen("img/3618.jpg");
        animes5.setNombre("Spy x Family");
        animes5.setDescripcion("Para el agente conocido como ‘Twilight’, ninguna orden es demasiado alta si es por el bien de la paz. Actuando como la espía maestra de Westalis, Twilight trabaja incansablemente para evitar que los extremistas inicien una guerra con el país vecino Ostania. Para su última misión, debe investigar al político ostaniano Donovan Desmond infiltrándose en la escuela de su hijo: la prestigiosa Academia Eden. Así, el agente se enfrenta a la tarea más difícil de su carrera: casarse, tener un hijo y jugar en familia.");
        animes5.setEstudio("Estudio:  CloverWorks, Wit Studio");
        animes5.setFechaPublicacion("Publicado: Noviembre 14, 2022");
        animes5.setActualizacion("Actualizado en: diciembre 10, 2022");

        var animes6=new Anime();
        animes6.setImagen("img/3641.jpg");
        animes6.setNombre("Overlord Temporada 4 Latino");
        animes6.setDescripcion("Ainz estaba pensando. “¿Cómo debo gobernar este país como el rey del reino mágico de Ainz Ooal Gown?”\n" +
                "\n" +
                "Gracias a Albedo y otros excelentes NPC y los muertos vivientes que podían trabajar sin descanso, el Reino Mágico ahora era un lugar seguro y libre de hambre. Sin embargo, las personas que vivían allí todavía temblaban de miedo y ansiedad, y la ciudad estaba tan tranquila como las luces se apagaron y perdieron su vitalidad. En medio de la falta de risas de la gente, Ainz visitó el Gremio de Aventureros y le hizo una sugerencia al Presidente del Gremio, Ainzack.");
        animes6.setEstudio("Estudio: Madhouse");
        animes6.setFechaPublicacion("Publicado:  Publicado el: julio 27, 2022");
        animes6.setActualizacion("Actualizado en: octubre 19, 2022");

        var animes7=new Anime();
        animes7.setImagen("img/3686.jpg");
        animes7.setNombre("Golden Kamuy");
        animes7.setDescripcion("En Hokkaido, en las tierras del norte de Japón, Sugimoto sobrevivió a la guerra ruso-japonesa de la era Meiji. Apodado ‘Sugimoto el Inmortal’ durante la guerra, ahora busca las riquezas prometidas por la fiebre del oro, con la esperanza de salvar a la esposa viuda de su compañero guerrero ahora fallecido.");
        animes7.setEstudio("Estudio: Pierrot");
        animes7.setFechaPublicacion("Publicado:  octubre 2, 2022");
        animes7.setActualizacion("Actualizado en: noviembre 7, 2022");

        var animes8=new Anime();
        animes8.setImagen("img/3692.jpg");
        animes8.setNombre("Human Bug Daigaku");
        animes8.setDescripcion("Hirofumi Satake fue condenado a muerte por asesinar a su prometida. También es un ‘No-muerto’ que ha sobrevivido a varias situaciones desesperadas.");
        animes8.setEstudio("Estudio: DLE");
        animes8.setFechaPublicacion("Publicado: octubre 5, 2022");
        animes8.setActualizacion("Actualizado en: diciembre 14, 2022");


        ArrayList<Anime> columnasAnimes=new ArrayList<>();
        //conformo matriz 2*4
        ArrayList<ArrayList<Anime>> filasAnimes=new ArrayList<>();
         columnasAnimes.add(animesUno);
         columnasAnimes.add(animesDos);
         columnasAnimes.add(animes3);
         columnasAnimes.add(animes4);

         filasAnimes.add(columnasAnimes);

         columnasAnimes=new ArrayList<>();
         columnasAnimes.add(animes5);
         columnasAnimes.add(animes6);
         columnasAnimes.add(animes7);
         columnasAnimes.add(animes8);
         filasAnimes.add( columnasAnimes);
         modelo.addAttribute("matrizAnimes", filasAnimes);
        return modelo;
    }
}
