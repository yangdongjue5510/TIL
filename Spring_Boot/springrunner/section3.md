# XML파일을 자바로 읽기 & Junit으로 테스트 해보기

자바에서 xml 파일을 읽으려면, jaxb api를 사용해야한다.

jaxb를 gradle에 추가한 후, 다음같이 만들어보자.

## JaxbMovieReader 클래스

```java

public class JaxbMovieReader implements MovieReader {
    @Override
    public List<Movie> loadMovies() {
        try{
            final JAXBContext jaxb = JAXBContext.newInstance(MovieMetaData.class);
            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final InputStream content = ClassLoader.getSystemResourceAsStream("movie_metadata.xml");
            final Source source = new StreamSource(content);
            final MovieMetaData metadata = (MovieMetaData) unmarshaller.unmarshal(source);
            return metadata.toMovies();
        }catch (JAXBException e){
            throw new ApplicationException("fail to load xml data", e);
        }

    }

    @XmlRootElement(name = "moviemetadata")
    public static class MovieMetaData{
        private List<MovieData> movies;

        public List<MovieData> getMovies() {
            return movies;
        }

        public void setMovies(List<MovieData> movies) {
            this.movies = movies;
        }

        public List<Movie> toMovies(){
            return movies.stream().map(it -> it.toMovie()).collect(Collectors.toList());
        }
    }

    public static class MovieData{
        private String title;
        private List<String> genres;
        private String language;
        private String country;
        private int releaseYear;
        private String director;
        private List<String> actors;
        private URL imdbLink;
        private String watchedDate;

        public Movie toMovie(){
            String title = getTitle();
            List<String> genres = getGenres();
            String language = getLanguage();
            String country = getCountry();
            int releaseYear = getReleaseYear();
            String director = getDirector();
            List<String> actors = getActors();
            URL imdbLink = getImdbLink();
            String watchedDate = getWatchedDate();

            return moviebuddy.domain.Movie.of(title, genres, language, country, releaseYear, director, actors, imdbLink, watchedDate);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public List<String> getActors() {
            return actors;
        }

        public void setActors(List<String> actors) {
            this.actors = actors;
        }

        public URL getImdbLink() {
            return imdbLink;
        }

        public void setImdbLink(URL imdbLink) {
            this.imdbLink = imdbLink;
        }

        public String getWatchedDate() {
            return watchedDate;
        }

        public void setWatchedDate(String watchedDate) {
            this.watchedDate = watchedDate;
        }


    }
}

```



## Junit으로 테스트 하기

build.gradle 에 의존성 추가

```java
dependencies {
    ...
    testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.5.2'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher:1.5.1'
}
```

build.gradle 에 테스트 방식 정의

```java
test {
    useJUnitPlatform()
}
```

Test 클래스에 Junit테스트 메소드 추가

```java
public class JaxbMovieReaderTest {

    @Test
    void NotEmpty_LoadedMovies(){
        JaxbMovieReader jaxbMovieReader = new JaxbMovieReader();
        List<Movie> movies = jaxbMovieReader.loadMovies();

        Assertions.assertEquals(1375, movies.size());
    }
}
```

