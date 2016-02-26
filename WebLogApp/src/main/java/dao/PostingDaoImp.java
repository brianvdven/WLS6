/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Posting;

/**
 *
 * @author Administrator
 */
public class PostingDaoImp implements PostingDao {

    private HashMap<Long, Posting> postings;
    private Long nextId;

    public PostingDaoImp() {
        initWeblog();
    }

    public void initWeblog() {

        postings = new HashMap<Long, Posting>();

        postings.put(1L, new Posting(1L, "Aantal internetklanten neemt bij Proximus toe met 28.000", "De Belgische telecomprovider Proximus heeft er in het vierde kwartaal van 2015 30.000 tv-abonnees bijgekregen. Ook nam het aantal klanten dat internet afneemt in het laatste kwartaal toe met 28.000, wat met de hogere prijzen voor de pakketten zorgde voor een extra omzetstijging.\n"
                + "\nAan de andere kant nam het aantal vaste lijnen en gebelde minuten wel af, wat de omzet van de totale Proximus-groep deed dalen met 0,3 procent tot 1,5 miljard euro. Met een afname van 19.000 vaste lijnen houdt Proximus nog 2,78 miljoen vaste aansluitingen over. Toch steeg de winst door verschillende kostendrukkende maatregelen en door snijden in personeelskosten tot 199 miljoen euro, een toename van bijna 38 procent in vergelijking met vorig jaar.\n"
                + "\nBij de mobiele bellers wordt beduidend minder ge-smst blijkt verder uit de cijfers. Het totale klantenbestand bij de mobiele tak groeide met 5,8 procent naar ruim zes miljoen, vooral door een toename van het aantal abonnementen. Er werden 34.000 Prepaid-kaarten minder afgenomen in het vierde kwartaal en 157.000 over het hele jaar. Het aantal settopboxen voor tv nam net als vorig jaar ook toe met 10,5 procent naar 1.759.000 apparaten.\n"
                + "\nVerder meldt het bedrijf dat eind 2015 43 procent van het vaste netwerk gereed was voor vectoring, waardoor in een derde van de huishoudens internetsnelheden tot 100Mbit per seconde gehaald kunnen worden. De 4g-dekking zou buitenshuis 98,8 procent zijn. 4g+ door middel van carrier-aggregatie van de 800 en 1800MHz-band heeft een dekking van 30 procent."));
        postings.put(2L, new Posting(2L, "TU Delft test thuisaccu's op drie verschillende terreinen", "De TU Delft onderzoekt samen met Eneco drie projecten rond thuisaccu's. De accu's worden op drie terreinen aan de tand gevoeld, namelijk bruikbaarheid voor intelligent energiebeheer, het opladen van elektrische voertuigen en gelijkstroomtechnologie."));
        postings.put(3L, new Posting(3L, "Turing Robotics gaat telefoons in Finland produceren uit veiligheidsoverwegingen", "Turing Robotics Industries, kortweg TRI, heeft aangekondigd zijn hoofdkantoor en de productie van zijn Turing Phone te verplaatsen naar Salo, een stad in Finland. De verhuizing uit Californië zou ingegeven zijn door veiligheidsoverwegingen.\n"
                + "\nDe belangrijkste reden om voor Finland te kiezen is de wetgeving rond de bescherming van privacy in elektronische communicatie zegt ceo Steve Chao van TRI op Techcrunch. Zo wil het bedrijf zijn klanten ervan verzekeren dat het met de dataveiligheid en privacy van de telefoon goed zit.\n"
                + "\nOok kondigde TRI onlangs in een nieuwsbrief aan dat het in plaats van Android, Sailfish OS gaat draaien. Dit liet het bedrijf begin februari ook weten in een e-mail aan klanten die de telefoon al in de voorverkoop besteld hadden. Volgens het bericht van TRI draait Sailfish OS 'zeer snel op de Turing', waardoor mensen zich 'geen zorgen hoeven te maken over de prestaties op de Snapdragon 801, omdat Sailfish OS geoptimaliseerd is voor de Turing Phone'.\n"
                + "\nDe maker van Sailfish OS, Jolla, kondigde in 2015 een samenwerkingsverband aan met een eveneens Fins bedrijf SSH Communications om van Sailfish OS een veilig Europees smartphonebesturingssysteem te maken onder de naam Sailfish Secure OS."));
        nextId = 4L;
    }

    @Override
    public void create(Posting p) {
        if (p == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        p.setId(nextId);
        postings.put(nextId++, p);
    }

    ;

    @Override
    public List<Posting> findAll() {
        return new ArrayList(postings.values());
    }

    ;

     @Override
    public Posting find(Long id) {
        if (!postings.containsKey(id)) {
            throw new IllegalArgumentException("Id no found" + id);
        }
        return postings.get(id);
    }
}
