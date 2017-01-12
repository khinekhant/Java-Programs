import java.text.DecimalFormat;
public class Lego {
            private int id;
            private int series;
            private String name;
            private int pieces;
	public Lego(String name, int id , int series, int pieces){
		this.id = id;
		this.series = series;
		this.name = name;
		this.pieces = pieces;
	}
            public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSeries(){
        return series;
    }

    public int getPieces(){
        return pieces;
    }
	public String toString( )
	{
	String var = "ID # =  < " + id + " > Name = < "+ name +" >";
        	return var;
}
	public void describeInfo( ) {
		switch(series)
		{ case 1 :
		System.out.println("This is a Creator series!");
		break;
		case 2 :
		System.out.println("This is a City series!");
		break;
		case 3:
		System.out.println("This is a Speed series!");
		break;
		default :
		System.out.println("Sorry there is no such series !");
		break;
		}
}
	public double convertRM( double usd){
		double rm;
		rm = usd * 3.45;
		return rm;
}
	public double convertUSD( double rm){
		double usd;
		usd = rm / 3.45;
		return usd;
}
	public double checkPrice(int series,int pieces) {
		double price = 0.0 ;
		double  usd = 0.0;
		if(series == 1)
	{
		if(pieces <= 300)
		{ 
			usd = 49.99;
		}
		else if(300 < pieces && pieces <=500)
		{
			usd = 89.99;
		}
		else if (500<pieces && pieces <=1000)
		{
			usd = 109.99;
		}
		else 
		{
			usd = 159.99;
		}
	}
		else if (series == 2)
	{
		if(pieces <= 200 )
		{
			usd = 29.99;
		}
		else if(pieces > 200 && pieces <=500 )
		{
			usd = 69.99;
		}
		else
		{
			usd = 99.99;
		}
	}
		else if(series==3)
	{
		if(pieces <= 100)
		{
			usd = 14.99;
		}
		else if (pieces > 100)
		{
			usd = 49.99;
		}
	} 
		else
		{ 
			System.out.println(" Wrong series");
		}
	        price = convertRM(usd);
                return price;
                
}
		public double calculateTotal( int series, double prices, int quantity)
{               DecimalFormat currency = new DecimalFormat("0.00");
		double Totalprice = 0;
                
		if ( series == 1 )
		{
			
			if(quantity > 200 )
			{ 
				Totalprice = prices - (prices*0.1);
			}
			else
			{
				Totalprice = prices;
			}
		}
		else if(series == 2)
		{
			if(quantity<=200)
			{
				Totalprice = prices - 0;
			}
			else if(quantity>200 && quantity <=500)
			{
				Totalprice = prices -5;
			}
			else
			{
				Totalprice = prices-10;
			}
		}
		else if(series==3)
		{
			
			if(quantity > 50)
			{
					Totalprice = prices - (prices*0.15);
			}
			else
			{
				Totalprice = prices;
			}
		}
		return Double.parseDouble(currency.format(Totalprice));
                
			
		}
}
