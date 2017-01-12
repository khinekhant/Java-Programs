public class LegoMain {

    public static void main(String[] args) {
        
        
        
         System.out.println(Brick.welcome);

        double price;
        int series;
        int quantity;
        Lego[] anArray = new Lego[6];
        anArray[0] = new Lego("Lucy", 11411, 1, 50);
        anArray[1] = new Lego("Zeon.T", 11211, 2, 150);
        anArray[2] = new Lego("Gaeko", 11111, 3, 130);
        anArray[3] = new Lego("Teblo", 11511, 1, 550);
        anArray[4] = new Lego("Shan", 11311, 2, 650);
        anArray[5] = new Lego("Lily", 11611, 3, 30);

        for (int i=0;i<6;i++){
            System.out.println(anArray[i].toString());
            anArray[i].describeInfo();
            price = anArray[i].checkPrice(anArray[i].getSeries(), anArray[i].getPieces());
            series = anArray[i].getSeries();
            quantity = anArray[i].getPieces();
            System.out.println("Total Price with RM : "+ anArray[i].calculateTotal(series, price, quantity));
           
            
        }


    }
        // TODO code application logic here
    
}
