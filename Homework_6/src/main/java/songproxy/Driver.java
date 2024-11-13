package songproxy;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Song> songs = Arrays.asList(
                new Song(1, "Counting Stars", "Ryan", "Hits", 258),
                new Song(2, "Sugar", "Adam", "Best of 2015", 235),
                new Song(3, "See You Again", "Wiz", "Soundtrack", 229),
                new Song(4, "Hey Mama", "David", "Dance Hits", 217),
                new Song(5, "Sorry", "Justin", "Pop", 200)
        );

        // Real server and proxyServer server
        SongServiceRealServer realServer = new SongServiceRealServer(songs);
        SongServiceProxyServer proxyServer = new SongServiceProxyServer(realServer);

        // Non-cached, using proxyServer server
        System.out.println("Proxy Server: Song Search by 'ID = 1' - with 1 sec delay:");
        System.out.println(proxyServer.searchById(1));

        System.out.println("\nProxy Server: Song Search by Title 'Sugar' - with 1 sec delay:");
        System.out.println(proxyServer.searchByTitle("Sugar"));

        System.out.println("\nProxy Server: Song Search by Album 'Hits' - with 1 sec delay:");
        System.out.println(proxyServer.searchByAlbum("Hits"));

        // Without caching, using real server
        System.out.println("\nReal Server: Song Search by 'ID = 3' - with 1 sec delay:");
        System.out.println(realServer.searchById(3));

        System.out.println("\nReal Server: Song Search by Title 'Hey Mama' - with 1 sec delay:");
        System.out.println(realServer.searchByTitle("Hey Mama"));

        System.out.println("\nReal Server: Song Search by Album 'Hits' - with 1 sec delay:");
        System.out.println(realServer.searchByAlbum("Hits"));

        // Cached data in proxyServer for repeated song search
        System.out.println("\nCached data in proxyServer for repeated song search:");

        System.out.println("Cached Song Search by 'ID = 1' - no time delay:");
        System.out.println(proxyServer.searchById(1));

        System.out.println("\nCached Song Search by Title 'Sugar' - no time delay:");
        System.out.println(proxyServer.searchByTitle("Sugar"));

        System.out.println("\nCached Song Search by Album 'Hits' - no time delay:");
        System.out.println(proxyServer.searchByAlbum("Hits"));
    }
}