package songproxy;

public class Song {
    private Integer id;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(Integer id, String title, String artist, String album, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return "Song ID = " + id + ", Title = " + title + ", Artist = " + artist + ", Album = " + album + ", Duration = " + duration + " sec.";
    }
}