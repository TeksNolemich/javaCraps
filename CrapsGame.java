import java.util.Random; 
//Ishan Zaveri 79101206 
//Arthur Tharp 71223707
public class CrapsGame
{
	private int num_of_rolls;
	private CrapsMetricsMonitor game_metrics;

	public CrapsGame(CrapsMetricsMonitor monitor){
		num_of_rolls = 0; 
		game_metrics = monitor; 
	}
	
	public boolean playGame(){ 
		//runs a single game
		num_of_rolls = 0; 
		Random generator = new Random();
		int die_1 = generator.nextInt(6) + 1;
		int die_2 = generator.nextInt(6) + 1;
		int point_number;
		int total_roll = die_1 + die_2;
		num_of_rolls++; 
		System.out.println("Rolled a " + total_roll);
		if(total_roll == 2 || total_roll == 3 || total_roll == 12){
			System.out.println("***** Craps! You Lose! *****");
			game_metrics.set_craps_roll(game_metrics.get_craps_roll()+1);
			return false; 
		}
		else if(total_roll == 7 || total_roll == 11){ 
			System.out.println("***** Natural! You Win! *****");
			game_metrics.set_natural_roll(game_metrics.get_natural_roll()+1);
			return true; 
		}
		else{
		point_number = total_roll; 
		die_1 = generator.nextInt(6)+1; 
		die_2 = generator.nextInt(6)+1; 
		total_roll = die_1 + die_2;
		num_of_rolls++;
		System.out.println("Rolled a " + total_roll);
		while(total_roll != point_number){
			if(total_roll == 7){ 
				System.out.println("***** Crap out! You Lose *****");
				return false; 
			} 
			die_1 = generator.nextInt(6)+1; 
			die_2 = generator.nextInt(6)+1; 
			total_roll = die_1 + die_2;
			num_of_rolls++;
			System.out.println("Rolled a " + total_roll);
		}
		System.out.println("***** Rolled the point! You Win! *****");
			return true;
		}
		
	}
	
	public int get_rolls(){
		//returns the number of rolls
		return num_of_rolls;
	}
	
	public CrapsMetricsMonitor get_metrics(){ 
		//keeps track of all game metrics
		return game_metrics; 
	}
}
