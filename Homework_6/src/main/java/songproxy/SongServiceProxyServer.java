package songproxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxyServer implements SongService {
    private SongServiceRealServer realServer;
    private Map<Integer, Song> cacheById;
    private Map<String, List<Song>> cacheByTitle;
    private Map<String, List<Song>> cacheByAlbum;

    public SongServiceProxyServer(SongServiceRealServer realServer) {
        this.realServer = realServer;
        this.cacheById = new HashMap<>();
        this.cacheByTitle = new HashMap<>();
        this.cacheByAlbum = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (!cacheById.containsKey(songID)) {
            Song song = realServer.searchById(songID);
            if (song != null) { // Store in cache only if not null
                cacheById.put(songID, song);
            }
        }
        return cacheById.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!cacheByTitle.containsKey(title)) {
            List<Song> songs = realServer.searchByTitle(title);
            if (!songs.isEmpty()) { // Store in cache only if not null
                cacheByTitle.put(title, songs);
            }
        }
        return cacheByTitle.getOrDefault(title, List.of());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!cacheByAlbum.containsKey(album)) {
            List<Song> songs = realServer.searchByAlbum(album);
            if (!songs.isEmpty()) { // Store in cache only if not null
                cacheByAlbum.put(album, songs);
            }
        }
        return cacheByAlbum.getOrDefault(album, List.of());
    }

    // For testing cache contents
    public Map<Integer, Song> getCacheById() {
        return cacheById;
    }

    public Map<String, List<Song>> getCacheByTitle() {
        return cacheByTitle;
    }

    public Map<String, List<Song>> getCacheByAlbum() {
        return cacheByAlbum;
    }
}