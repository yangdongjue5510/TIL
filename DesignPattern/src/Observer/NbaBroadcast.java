package Observer;

public class NbaBroadcast {
    public static void main(String[] args) {
        NBAData nbaData = new NBAData();

        TNTDisplay tntDisplay = new TNTDisplay(nbaData);
        NBCDisplay currentConditionsDisplay = new NBCDisplay(nbaData);

        nbaData.setMeasurements(10.2f, 5.23f, 3.3f);
        nbaData.setMeasurements(20.4f, 12.4f, 7.4f);
    }
}
