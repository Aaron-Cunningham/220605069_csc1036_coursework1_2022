import java.util.ArrayList;

public class Reporting {

    public ArrayList<AuctionHouse> auctionHouses = new ArrayList<>();

    public boolean addItem(Item item) {
        for (AuctionHouse auctionHouse:auctionHouses){
            if(auctionHouse.addItem(item)){
                return true;
            }
        }
        return false;

    }

}
