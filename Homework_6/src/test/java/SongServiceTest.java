package songproxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SongServiceTest {
    private SongServiceRealServer realServer;
    private SongServiceProxyServer proxyServer;
    private List<Song> songs;

    @BeforeEach
    public void setUp() {
        songs = Arrays.asList(
                new Song(1, "Counting Stars", "Ryan", "Hits", 258),
                new Song(2, "Sugar", "Adam", "Best of 2015", 235),
                new Song(3, "See You Again", "Wiz", "Soundtrack", 229),
                new Song(4, "Hey Mama", "David", "Dance Hits", 217),
                new Song(5, "Sorry", "Justin", "Pop", 200)
        );

        realServer = new SongServiceRealServer(songs);
        proxyServer = new SongServiceProxyServer(realServer);
    }

    // Test for SongServiceRealServer methods
    @Test
    public void testRealServerSearchById() {
        Song song = realServer.searchById(1);
        assertNotNull(song);
        assertEquals("Counting Stars", song.getTitle());

        Song nonExistentSong = realServer.searchById(999);
        assertNull(nonExistentSong);
    }

    @Test
    public void testRealServerSearchByTitle() {
        List<Song> result = realServer.searchByTitle("Sugar");
        assertEquals(1, result.size());
        assertEquals("Sugar", result.get(0).getTitle());

        List<Song> emptyResult = realServer.searchByTitle("NonExistentTitle");
        assertTrue(emptyResult.isEmpty());
    }

    @Test
    public void testRealServerSearchByAlbum() {
        List<Song> result = realServer.searchByAlbum("Hits");
        assertEquals(1, result.size());
        assertEquals("Counting Stars", result.get(0).getTitle());

        List<Song> emptyResult = realServer.searchByAlbum("NonExistentAlbum");
        assertTrue(emptyResult.isEmpty());
    }

    // Test for SongServiceProxyServer methods (with caching)
    @Test
    public void testProxySearchById_withCaching() {
        Song song = proxyServer.searchById(1);
        assertNotNull(song);
        assertEquals("Counting Stars", song.getTitle());

        // Check cache
        Map<Integer, Song> cacheById = proxyServer.getCacheById();
        assertTrue(cacheById.containsKey(1));

        Song cachedSong = proxyServer.searchById(1);
        assertSame(song, cachedSong);
    }

    @Test
    public void testProxySearchByTitle_withCaching() {
        List<Song> result = proxyServer.searchByTitle("Sugar");
        assertEquals(1, result.size());
        assertEquals("Sugar", result.get(0).getTitle());

        // Check cache
        Map<String, List<Song>> cacheByTitle = proxyServer.getCacheByTitle();
        assertTrue(cacheByTitle.containsKey("Sugar"));

        List<Song> cachedResult = proxyServer.searchByTitle("Sugar");
        assertSame(result, cachedResult);
    }

    @Test
    public void testProxySearchByAlbum_withCaching() {
        List<Song> result = proxyServer.searchByAlbum("Hits");
        assertEquals(1, result.size());
        assertEquals("Counting Stars", result.get(0).getTitle());

        // Check cache
        Map<String, List<Song>> cacheByAlbum = proxyServer.getCacheByAlbum();
        assertTrue(cacheByAlbum.containsKey("Hits"));

        List<Song> cachedResult = proxyServer.searchByAlbum("Hits");
        assertSame(result, cachedResult);
    }

    @Test
    public void testProxySearchById_notFound() {
        Song nonExistentSong = proxyServer.searchById(999);
        assertNull(nonExistentSong);

        // Check cache isn't updated for new data
        Map<Integer, Song> cacheById = proxyServer.getCacheById();
        assertFalse(cacheById.containsKey(999));
    }

    @Test
    public void testProxySearchByTitle_notFound() {
        List<Song> emptyResult = proxyServer.searchByTitle("NoTitle");
        assertTrue(emptyResult.isEmpty());

        // Check cache isn't updated for empty data
        Map<String, List<Song>> cacheByTitle = proxyServer.getCacheByTitle();
        assertFalse(cacheByTitle.containsKey("NoTitle"));
    }

    @Test
    public void testProxySearchByAlbum_notFound() {
        List<Song> emptyResult = proxyServer.searchByAlbum("NoAlbum");
        assertTrue(emptyResult.isEmpty());

        // Check cache isn't updated for empty data
        Map<String, List<Song>> cacheByAlbum = proxyServer.getCacheByAlbum();
        assertFalse(cacheByAlbum.containsKey("NoAlbum"));
    }

    // Test for Song class
    @Test
    public void testSongAttributesAndToString() {
        Song song = new Song(1, "Counting Stars", "Ryan", "Hits", 258);
        assertEquals(1, song.getId());
        assertEquals("Counting Stars", song.getTitle());
        assertEquals("Ryan", song.getArtist());
        assertEquals("Hits", song.getAlbum());
        assertEquals(258, song.getDuration());

        String expectedString = "Song ID = 1, Title = Counting Stars, Artist = Ryan, Album = Hits, Duration = 258 sec.";
        assertEquals(expectedString, song.toString());
    }

    @Test
    public void testDriverScenario() {
        Song songById = proxyServer.searchById(1);
        assertNotNull(songById);
        assertEquals("Counting Stars", songById.getTitle());

        List<Song> songsByTitle = proxyServer.searchByTitle("Sugar");
        assertEquals(1, songsByTitle.size());
        assertEquals("Sugar", songsByTitle.get(0).getTitle());

        List<Song> songsByAlbum = proxyServer.searchByAlbum("Hits");
        assertEquals(1, songsByAlbum.size());
        assertEquals("Counting Stars", songsByAlbum.get(0).getTitle());

        // Check cache on repeated searches
        Song cachedSongById = proxyServer.searchById(1);
        assertSame(songById, cachedSongById);

        List<Song> cachedSongsByTitle = proxyServer.searchByTitle("Sugar");
        assertSame(songsByTitle, cachedSongsByTitle);

        List<Song> cachedSongsByAlbum = proxyServer.searchByAlbum("Hits");
        assertSame(songsByAlbum, cachedSongsByAlbum);
    }

    // Test for empty song list
    @Test
    public void testEmptyRealServer() {
        SongServiceRealServer emptyServer = new SongServiceRealServer(Arrays.asList());
        SongServiceProxyServer emptyProxy = new SongServiceProxyServer(emptyServer);

        assertNull(emptyProxy.searchById(1));
        assertTrue(emptyProxy.searchByTitle("NotExists").isEmpty());
        assertTrue(emptyProxy.searchByAlbum("NotExists").isEmpty());
    }
}